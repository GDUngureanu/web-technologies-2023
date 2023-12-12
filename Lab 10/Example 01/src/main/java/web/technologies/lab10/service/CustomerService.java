package web.technologies.lab10.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab10.entity.Customer;
import web.technologies.lab10.exception.CustomerNotFound;
import web.technologies.lab10.mapper.CustomerMapper;
import web.technologies.lab10.repository.CustomerRepository;
import web.technologies.lab10.request.CustomerRequest;
import web.technologies.lab10.response.CustomerResponse;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = CustomerMapper.toEntity(request);
        customer = customerRepository.save(customer);
        return CustomerMapper.toResponse(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
            .map(CustomerMapper::toResponse)
            .collect(Collectors.toList());
    }

    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFound("Customer not found for id: " + id));
        return CustomerMapper.toResponse(customer);
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest request) {
        Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFound("Customer not found for id: " + id));

        Customer updatedCustomer = CustomerMapper.toEntity(request);
        updatedCustomer.setId(existingCustomer.getId());
        customerRepository.save(updatedCustomer);
        return CustomerMapper.toResponse(updatedCustomer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFound("Customer not found for id: " + id);
        }

        customerRepository.deleteById(id);
    }
}


