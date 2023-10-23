package web.technologies.lab03.model.textile;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import web.technologies.lab03.model.fashion.Design;

@ToString
@RequiredArgsConstructor
public class Product {

    private final UUID serialNumber;
    private final Design design;
    private final String material;
    private final String size;

}
