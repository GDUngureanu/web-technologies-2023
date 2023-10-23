package web.technologies.lab03.model.textile;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import web.technologies.lab03.model.fashion.Design;

@ToString
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class Product {

    private final UUID serialNumber = UUID.randomUUID();
    private final Design design;
    private final String material;
    private final String size;

}
