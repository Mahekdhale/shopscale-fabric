package com.shopscale.inventory.kafka;

import com.shopscale.inventory.event.OrderPlacedEvent;
import com.shopscale.inventory.model.Inventory;
import com.shopscale.inventory.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    // Fix for: log cannot be resolved
    private static final Logger log = LoggerFactory.getLogger(InventoryConsumer.class);

    // Fix for: inventoryRepository may not have been initialized
    private final InventoryRepository inventoryRepository;

    // Manual constructor replacing @RequiredArgsConstructor
    public InventoryConsumer(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @KafkaListener(topics = "order-placed", groupId = "inventory-group")
    public void consumeOrderPlacedEvent(OrderPlacedEvent event) {
        log.info("Received OrderPlacedEvent for order: {}", event.getOrderNumber());

        Inventory inventory = inventoryRepository
            .findByProductId(event.getProductId())
            .orElseThrow(() -> new RuntimeException(
                "Product not in inventory: " + event.getProductId()));

        inventory.setQuantity(inventory.getQuantity() - event.getQuantity());
        inventoryRepository.save(inventory);

        log.info("Inventory updated for product: {}", event.getProductId());
    }
}