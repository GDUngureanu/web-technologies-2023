package web.technologies.lab09.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab09.entity.Customer;
import web.technologies.lab09.entity.DeliveryAddress;
import web.technologies.lab09.mapper.DeliveryAddressMapper;
import web.technologies.lab09.repository.CustomerRepository;
import web.technologies.lab09.repository.DeliveryAddressRepository;
import web.technologies.lab09.request.DeliveryAddressRequest;
import web.technologies.lab09.response.DeliveryAddressResponse;

@Service
public class DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public DeliveryAddressResponse createDeliveryAddress(DeliveryAddressRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found for id: " + request.getCustomerId()));

        DeliveryAddress address = DeliveryAddressMapper.toEntity(request);
        address.setCustomer(customer);
        address = deliveryAddressRepository.save(address);
        return DeliveryAddressMapper.toResponse(address);
    }

    public List<DeliveryAddressResponse> getAllDeliveryAddresses() {
        return deliveryAddressRepository.findAll().stream()
            .map(DeliveryAddressMapper::toResponse)
            .collect(Collectors.toList());
    }

    public DeliveryAddressResponse getDeliveryAddressById(Long id) {
        DeliveryAddress address = deliveryAddressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Delivery address not found for id: " + id));
        return DeliveryAddressMapper.toResponse(address);
    }

    public DeliveryAddressResponse updateDeliveryAddress(Long id, DeliveryAddressRequest request) {
        DeliveryAddress existingAddress = deliveryAddressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Delivery address not found for id: " + id));

        DeliveryAddress updatedAddress = DeliveryAddressMapper.toEntity(request);
        updatedAddress.setId(existingAddress.getId());
        deliveryAddressRepository.save(updatedAddress);
        return DeliveryAddressMapper.toResponse(updatedAddress);
    }

    public void deleteDeliveryAddress(Long id) {
        if (!deliveryAddressRepository.existsById(id)) {
            throw new RuntimeException("Delivery address not found for id: " + id);
        }

        deliveryAddressRepository.deleteById(id);
    }
}
