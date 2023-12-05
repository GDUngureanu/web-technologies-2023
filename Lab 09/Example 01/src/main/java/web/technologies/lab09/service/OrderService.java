package web.technologies.lab09.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab09.entity.Customer;
import web.technologies.lab09.entity.Order;
import web.technologies.lab09.entity.OrderItem;
import web.technologies.lab09.entity.Product;
import web.technologies.lab09.mapper.OrderMapper;
import web.technologies.lab09.repository.CustomerRepository;
import web.technologies.lab09.repository.OrderRepository;
import web.technologies.lab09.repository.ProductRepository;
import web.technologies.lab09.request.OrderRequest;
import web.technologies.lab09.response.OrderResponse;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderMapper orderMapper;

    public OrderResponse createOrder(OrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<OrderItem> items = request.getItems().stream()
            .map(itemRequest -> {
                Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
                OrderItem item = new OrderItem();
                item.setProduct(product);
                item.setQuantity(itemRequest.getQuantity());
                return item;
            }).collect(Collectors.toList());

        Order order = orderMapper.toEntity(customer, items);
        order = orderRepository.save(order);
        return orderMapper.toResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
            .map(orderMapper::toResponse)
            .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found for id: " + id));
        return orderMapper.toResponse(order);
    }

    public OrderResponse updateOrder(Long id, OrderRequest request) {
        Order existingOrder = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found for id: " + id));

        List<OrderItem> items = request.getItems().stream()
            .map(itemRequest -> {
                Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
                OrderItem item = new OrderItem();
                item.setProduct(product);
                item.setQuantity(itemRequest.getQuantity());
                return item;
            }).collect(Collectors.toList());

        existingOrder.setOrderItems(items);
        existingOrder.setTotalAmount(orderMapper.calculateTotal(items));

        orderRepository.save(existingOrder);
        return orderMapper.toResponse(existingOrder);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found for id: " + id);
        }

        orderRepository.deleteById(id);
    }


}

