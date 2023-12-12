package web.technologies.lab10.request;

import lombok.Data;

@Data
public class DeliveryAddressRequest {

    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String deliveryInstructions;
    private Long customerId;

}

