package web.technologies.lab10.mapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import web.technologies.lab10.entity.Customer;
import web.technologies.lab10.entity.Order;
import web.technologies.lab10.entity.OrderItem;
import web.technologies.lab10.response.OrderItemResponse;
import web.technologies.lab10.response.OrderResponse;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();

        response.setId(order.getId());
        response.setOrderDate(order.getOrderDate());
        response.setTotalAmount(order.getTotalAmount());
        response.setItems(order.getOrderItems().stream()
            .map(item -> new OrderItemResponse(item.getId(), item.getProduct().getName(), item.getQuantity()))
            .collect(Collectors.toList()));

        return response;
    }

    public Order toEntity(Customer customer, List<OrderItem> items) {
        Order order = new Order();

        order.setCustomer(customer);
        order.setOrderDate(new Date());
        order.setTotalAmount(calculateTotal(items));
        order.setOrderItems(items);

        return order;
    }

    public Double calculateTotal(List<OrderItem> items) {
        return items.stream()
            .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
            .sum();
    }
}

