package com.shopscale.order.kafka;

import com.shopscale.order.event.OrderPlacedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    // Fix for: log cannot be resolved
    private static final Logger log = LoggerFactory.getLogger(OrderProducer.class);

    // Fix for: kafkaTemplate may not have been initialized
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    // Manual constructor replacing @RequiredArgsConstructor
    public OrderProducer(KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderPlacedEvent(OrderPlacedEvent event) {
        log.info("Publishing OrderPlacedEvent: {}", event.getOrderNumber());
        kafkaTemplate.send("order-placed", event);
    }
}