package web.technologies.lab03.service.textile;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import web.technologies.lab03.model.textile.Product;

public class TextileStorage {

    @Getter
    private final List<Product> storedProducts = new ArrayList<>();

    public void storeProducts(List<Product> manufacturedProducts) {
        this.storedProducts.addAll(manufacturedProducts);
    }

}
