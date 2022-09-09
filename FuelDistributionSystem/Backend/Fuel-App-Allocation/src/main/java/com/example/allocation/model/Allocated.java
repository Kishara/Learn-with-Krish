package com.example.allocation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Allocated")
public class Allocated {

    @Id
    private int orderId;
    private String fuelType;
    private int quantity;

    public Allocated() {}

    public Allocated(int orderId, String fuelType, int quantity) {
        super();
        this.orderId = orderId;
        this.fuelType = fuelType;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
