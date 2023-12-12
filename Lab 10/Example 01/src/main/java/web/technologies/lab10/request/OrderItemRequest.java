package web.technologies.lab10.request;

import lombok.Data;

@Data
public class OrderItemRequest {

    private Long productId;
    private Integer quantity;

}
