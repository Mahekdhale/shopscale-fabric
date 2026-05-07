package com.shopscale.order.event;

public class OrderPlacedEvent {

    private String orderNumber;
    private String productId;
    private Integer quantity;

    // Default constructor
    public OrderPlacedEvent() {}

    // Parameterized constructor
    public OrderPlacedEvent(String orderNumber, String productId, Integer quantity) {
        this.orderNumber = orderNumber;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters
    public String getOrderNumber() { return orderNumber; }
    public String getProductId() { return productId; }
    public Integer getQuantity() { return quantity; }

    // Setters
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public void setProductId(String productId) { this.productId = productId; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "OrderPlacedEvent{" +
                "orderNumber='" + orderNumber + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}