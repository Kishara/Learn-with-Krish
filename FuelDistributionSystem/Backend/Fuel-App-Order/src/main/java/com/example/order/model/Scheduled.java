package com.example.order.model;

public class Scheduled {

    private int orderId;
    private String date;

    public Scheduled() {}

    public Scheduled(int orderId, String date) {
        this.orderId = orderId;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
