package web.technologies.lab07.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    
    private String description;
    private float price;
    
}
