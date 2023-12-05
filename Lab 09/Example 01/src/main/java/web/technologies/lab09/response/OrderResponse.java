package web.technologies.lab09.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {

    private Long id;
    private Date orderDate;
    private Double totalAmount;
    private List<OrderItemResponse> items;

}
