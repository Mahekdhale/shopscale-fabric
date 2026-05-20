package com.shopscale.order.controller;

import com.shopscale.order.model.Order;
import com.shopscale.order.model.OrderStatus;
import com.shopscale.order.repository.OrderRepository;
import com.shopscale.order.kafka.OrderProducer;
import com.shopscale.order.event.OrderPlacedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderController(OrderRepository orderRepository,
                           OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order placeOrder(@RequestBody Order order) {
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        OrderPlacedEvent event = new OrderPlacedEvent(
            savedOrder.getOrderNumber(),
            savedOrder.getProductId(),
            savedOrder.getQuantity()
        );
        orderProducer.sendOrderPlacedEvent(event);

        return savedOrder;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}