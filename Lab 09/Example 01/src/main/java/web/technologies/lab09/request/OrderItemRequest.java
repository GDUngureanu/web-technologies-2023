package web.technologies.lab09.request;

import lombok.Data;

@Data
public class OrderItemRequest {

    private Long productId;
    private Integer quantity;

}
