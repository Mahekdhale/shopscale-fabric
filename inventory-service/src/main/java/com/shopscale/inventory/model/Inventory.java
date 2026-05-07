package com.shopscale.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private Integer quantity;

    public Inventory() {}

    public Inventory(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters
    public Long getId() { return id; }
    public String getProductId() { return productId; }
    public Integer getQuantity() { return quantity; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setProductId(String productId) { this.productId = productId; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}