package web.technologies.lab10.mapper;

import static java.util.Objects.isNull;

import web.technologies.lab10.entity.DeliveryAddress;
import web.technologies.lab10.request.DeliveryAddressRequest;
import web.technologies.lab10.response.DeliveryAddressResponse;

public class DeliveryAddressMapper {

    public static DeliveryAddressResponse toResponse(DeliveryAddress deliveryAddress) {
        if (isNull(deliveryAddress)) {
            return null;
        }
        
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
        if (isNull(request)) {
            return null;
        }

        DeliveryAddress address = new DeliveryAddress();

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setPostalCode(request.getPostalCode());
        address.setCountry(request.getCountry());
        address.setDeliveryInstructions(request.getDeliveryInstructions());

        return address;
    }
}
