package com.example.allocation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Available")
public class Available {

    @Id
    private int id;
    private String fuelType;
    private int quantity;

    public Available() {}

    public Available(int id, String fuelType, int quantity) {
        super();
        this.id = id;
        this.fuelType = fuelType;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Available{" +
                "Id=" + id +
                ", fuelType='" + fuelType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
