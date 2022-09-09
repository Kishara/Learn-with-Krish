package com.example.allocation.repository;

import com.example.allocation.model.Available;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableRepository extends MongoRepository<Available, Integer> {

    Available findByFuelType(String type);
}
