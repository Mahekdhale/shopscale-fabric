package com.shopscale.inventory.controller;

import com.shopscale.inventory.model.Inventory;
import com.shopscale.inventory.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/{skuCode}")
    public String checkStock(@PathVariable String skuCode) {

        boolean exists = inventoryRepository.existsBySkuCode(skuCode);

        if (exists) {
            return skuCode + " is in stock";
        }

        return skuCode + " is out of stock";
    }
}