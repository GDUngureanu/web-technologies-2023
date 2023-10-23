package web.technologies.lab03.service.textile;

import java.util.UUID;

import web.technologies.lab03.model.fashion.Design;
import web.technologies.lab03.model.textile.Product;

public class Operator {

    public Product stitch(final Design design, final String material, final String size) {
        return new Product(UUID.randomUUID(), design, material, size);
    }

}
