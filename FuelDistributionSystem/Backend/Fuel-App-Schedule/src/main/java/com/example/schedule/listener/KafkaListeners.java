package com.example.schedule.listener;

import com.example.schedule.model.Allocated;
import com.example.schedule.service.ScheduleService;
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
    ScheduleService scheduleService;

    @KafkaListener(topics = "allocationTopic", groupId = "TestGroup")
    public void consumeJson(@Payload List<Allocated> data){

        String value = String.valueOf(data);
        int orderId = 0;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Allocated> allocatedOrders = objectMapper.readValue(value, new TypeReference<List<Allocated>>(){});
            for(Allocated order : allocatedOrders) {
                orderId  = order.getOrderId();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(scheduleService.deliveryDate(orderId));

    }
}
