package web.technologies.lab09.response;

import lombok.Data;

@Data
public class DeliveryAddressResponse {

    private Long id;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String deliveryInstructions;

}

