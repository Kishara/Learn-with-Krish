package com.example.order.repository;

import com.example.order.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, Integer> {

    public List<OrderModel> findBygasStationId(int id);

}
