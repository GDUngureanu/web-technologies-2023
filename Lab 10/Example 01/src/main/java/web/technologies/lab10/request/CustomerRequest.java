package web.technologies.lab10.request;

import lombok.Data;

@Data
public class CustomerRequest {

    private String name;
    private String email;
    private DeliveryAddressRequest deliveryAddress;

}

