package web.technologies.lab09.request;

import java.util.Set;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private String description;
    private Double price;
    private Set<Long> categoryIds;

}
