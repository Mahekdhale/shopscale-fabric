package com.shopscale.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;

    private String skuCode;

    private Integer quantity;

    public Inventory() {}

    public Inventory(String productId, String skuCode, Integer quantity) {
        this.productId = productId;
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}