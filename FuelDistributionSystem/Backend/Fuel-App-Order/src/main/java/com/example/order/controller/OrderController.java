package com.example.order.controller;

import com.example.order.model.OrderModel;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/v1/orders")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderModel> placeOrder(@RequestBody OrderModel orderModel) {
        return orderService.saveOrder(orderModel);
    }

    @GetMapping("/{gasStationId}")
    public ResponseEntity<List<OrderModel>> getOrder(@PathVariable int gasStationId){
        return orderService.getOrder(gasStationId);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<OrderModel> orderReceived(@PathVariable int id, @PathVariable String status) {
        return orderService.orderReceived(id,status);
    }

    @GetMapping
    public ResponseEntity<List<OrderModel>> getAllOrders(){
        return orderService.getAllOrders();
    }

}
