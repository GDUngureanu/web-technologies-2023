package web.technologies.lab09.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import web.technologies.lab09.entity.Category;
import web.technologies.lab09.entity.Product;
import web.technologies.lab09.request.ProductRequest;
import web.technologies.lab09.response.ProductResponse;

@Component
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategories(product.getCategories().stream()
            .map(Category::getName)
            .collect(Collectors.toSet()));

        return response;
    }

    public Product toEntity(ProductRequest request, Set<Category> categories) {
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategories(categories);

        return product;
    }

}
