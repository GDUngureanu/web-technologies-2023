package web.technologies.lab03.service.textile;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import web.technologies.lab03.model.fashion.Design;
import web.technologies.lab03.model.textile.Product;

@RequiredArgsConstructor
public class Operator {

    private final ApplicationContext context;

    public Product stitch(final Design design, final String material, final String size) {
        return context.getBean(Product.class, design, material, size);
    }

}
