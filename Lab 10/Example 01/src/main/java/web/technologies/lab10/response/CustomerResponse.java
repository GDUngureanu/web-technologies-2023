package web.technologies.lab10.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private DeliveryAddressResponse deliveryAddress;

}

