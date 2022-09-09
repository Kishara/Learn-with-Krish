package com.example.order.listener;

import com.example.order.model.Scheduled;
import com.example.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListener {

    @Autowired
    OrderService orderService;

    @org.springframework.kafka.annotation.KafkaListener(topics = "scheduleTopic", groupId = "TestGroup")
    public void consumeJson(@Payload List<Scheduled> data){

        String value = String.valueOf(data);
        int orderId = 0;
        String status = "Scheduled";
        String date = "";


        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Scheduled> orders = objectMapper.readValue(value, new TypeReference<List<Scheduled>>(){});
            for(Scheduled order : orders) {
                orderId  = order.getOrderId();
                date = order.getDate();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        orderService.orderReceived(orderId, status, date);

    }
}
