package web.technologies.lab09.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private DeliveryAddressResponse deliveryAddress;

}

