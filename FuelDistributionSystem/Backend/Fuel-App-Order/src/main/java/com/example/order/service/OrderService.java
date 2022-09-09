package com.example.order.service;

import com.example.order.config.KafkaTopicConfig;
import com.example.order.model.OrderModel;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    KafkaTemplate<String, OrderModel> kafkaTemplate;

    public ResponseEntity<OrderModel> saveOrder(OrderModel orderModel) {

        Random number = new Random();
        int id  = number.nextInt(2500);

        orderModel.setOrderId(id);
        kafkaTemplate.send(KafkaTopicConfig.PROJECTTOPIC, orderModel);
        orderRepository.save(orderModel);

        return ResponseEntity.status(HttpStatus.OK).body(orderModel);
    }

    public ResponseEntity<List<OrderModel>> getOrder(int gasStationId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findBygasStationId(gasStationId));
    }

    public ResponseEntity<List<OrderModel>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
    }

    public ResponseEntity<OrderModel> orderReceived(int id, String status) {

        Optional<OrderModel> byId = orderRepository.findById(id);

        if(byId.isPresent()) {
            OrderModel orderModel = byId.get();

            orderModel.setStatus(status);
            orderRepository.save(orderModel);
            return ResponseEntity.status(HttpStatus.OK).body(orderModel);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<OrderModel> orderReceived(int id, String status, String date) {

        Optional<OrderModel> byId = orderRepository.findById(id);

        if(byId.isPresent()) {
            OrderModel orderModel = byId.get();

            orderModel.setStatus(status);
            orderModel.setDate(date);
            orderRepository.save(orderModel);
            return ResponseEntity.status(HttpStatus.OK).body(orderModel);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
