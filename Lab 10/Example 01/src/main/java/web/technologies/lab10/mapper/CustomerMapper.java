package web.technologies.lab10.mapper;

import web.technologies.lab10.entity.Customer;
import web.technologies.lab10.request.CustomerRequest;
import web.technologies.lab10.response.CustomerResponse;

public class CustomerMapper {

    public static CustomerResponse toResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();

        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setDeliveryAddress(DeliveryAddressMapper.toResponse(customer.getDeliveryAddress()));

        return response;
    }

    public static Customer toEntity(CustomerRequest request) {
        Customer customer = new Customer();

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setDeliveryAddress(DeliveryAddressMapper.toEntity(request.getDeliveryAddress()));

        return customer;
    }
}

