package com.example.schedule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Schedule")
public class Scheduled {

    @Id
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
