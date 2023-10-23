package web.technologies.lab03.service.textile;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import web.technologies.lab03.model.fashion.Design;
import web.technologies.lab03.model.textile.Product;

@RequiredArgsConstructor
public class TextileFactory {

    private final Operator operator = new Operator();
    private final TextileStorage textileStorage = new TextileStorage();

    public List<Product> manufactureProducts(Design design, int quantity, String material, String size) {
        List<Product> manufacturedProducts = new ArrayList<>();

        for (int productNumber = 0; productNumber < quantity; productNumber++) {
            Product product = operator.stitch(design, material, size);

            manufacturedProducts.add(product);
        }

        shipProducts(manufacturedProducts);

        return manufacturedProducts;
    }

    private void shipProducts(List<Product> products) {
        textileStorage.storeProducts(products);
    }

}
