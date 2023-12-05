package web.technologies.lab09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab09.request.DeliveryAddressRequest;
import web.technologies.lab09.response.DeliveryAddressResponse;
import web.technologies.lab09.service.DeliveryAddressService;

@RestController
@RequestMapping("/deliveryAddresses")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @PostMapping
    public ResponseEntity<DeliveryAddressResponse> createDeliveryAddress(@RequestBody DeliveryAddressRequest request) {
        return ResponseEntity.ok(deliveryAddressService.createDeliveryAddress(request));
    }

    @GetMapping
    public List<DeliveryAddressResponse> getAllDeliveryAddresses() {
        return deliveryAddressService.getAllDeliveryAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryAddressResponse> getDeliveryAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryAddressService.getDeliveryAddressById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryAddressResponse> updateDeliveryAddress(@PathVariable Long id, @RequestBody DeliveryAddressRequest request) {
        return ResponseEntity.ok(deliveryAddressService.updateDeliveryAddress(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeliveryAddress(@PathVariable Long id) {
        deliveryAddressService.deleteDeliveryAddress(id);
        return ResponseEntity.ok().build();
    }
}
