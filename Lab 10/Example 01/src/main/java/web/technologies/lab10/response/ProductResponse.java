package web.technologies.lab10.response;

import java.util.Set;

import lombok.Data;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Set<String> categories;

}
