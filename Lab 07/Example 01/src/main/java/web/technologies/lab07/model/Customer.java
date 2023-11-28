package web.technologies.lab07.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    
    private String name;
    private String email;
    private String password;
    private String deliveryAddress;
        
}
