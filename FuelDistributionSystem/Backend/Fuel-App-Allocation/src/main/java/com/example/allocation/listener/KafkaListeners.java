package com.example.allocation.listener;


import com.example.allocation.model.OrderModel;
import com.example.allocation.service.AvailableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    AvailableService availableService;



    @KafkaListener(topics = "orderTopic", groupId = "TestGroup")
    public void consumeJson(@Payload List<OrderModel> data){

        String value = String.valueOf(data);
        String fuelType = "";
        String status = "";
        int orderId = 0;
        int quantity = 0;

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<OrderModel> orderModels = objectMapper.readValue(value, new TypeReference<List<OrderModel>>(){});
            for(OrderModel orderModel : orderModels) {
                fuelType = orderModel.getFuelType();
                quantity = orderModel.getAmount();
                status = orderModel.getStatus();
                orderId  = orderModel.getOrderId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        availableService.getCapacity(fuelType,quantity,orderId);

    }
}
