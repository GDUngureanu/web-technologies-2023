package web.technologies.lab09.mapper;

import web.technologies.lab09.entity.DeliveryAddress;
import web.technologies.lab09.request.DeliveryAddressRequest;
import web.technologies.lab09.response.DeliveryAddressResponse;

public class DeliveryAddressMapper {

    public static DeliveryAddressResponse toResponse(DeliveryAddress deliveryAddress) {
        DeliveryAddressResponse response = new DeliveryAddressResponse();

        response.setId(deliveryAddress.getId());
        response.setStreet(deliveryAddress.getStreet());
        response.setCity(deliveryAddress.getCity());
        response.setPostalCode(deliveryAddress.getPostalCode());
        response.setCountry(deliveryAddress.getCountry());
        response.setDeliveryInstructions(deliveryAddress.getDeliveryInstructions());

        return response;
    }

    public static DeliveryAddress toEntity(DeliveryAddressRequest request) {
        DeliveryAddress address = new DeliveryAddress();

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setPostalCode(request.getPostalCode());
        address.setCountry(request.getCountry());
        address.setDeliveryInstructions(request.getDeliveryInstructions());

        return address;
    }
}
