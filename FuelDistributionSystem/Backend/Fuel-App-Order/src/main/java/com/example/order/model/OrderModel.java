package com.example.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order")
public class OrderModel {

    @Id
    private int orderId;

    private String gasStationName;
    private int gasStationId;
    private int amount;
    private String fuelType;
    private String status = "Pending";
    private String date = "Pending";

    public OrderModel() {}

    public OrderModel(int orderId, String gasStationName, int gasStationId, int amount, String fuelType, String status, String date) {
        super();
        this.orderId = orderId;
        this.gasStationName = gasStationName;
        this.gasStationId = gasStationId;
        this.amount = amount;
        this.fuelType = fuelType;
        this.status = status;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getGasStationName() {
        return gasStationName;
    }

    public void setGasStationName(String gasStationName) {
        this.gasStationName = gasStationName;
    }

    public int getGasStationId() {
        return gasStationId;
    }

    public void setGasStationId(int gasStationId) {
        this.gasStationId = gasStationId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
