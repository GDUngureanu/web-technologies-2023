package web.technologies.lab07.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class User { 

    private UUID id;
    
    private String name;
    private String email;
    private String deliveryAddress;
    private String company;
    private String address;
    
    private UserRole role;

}

