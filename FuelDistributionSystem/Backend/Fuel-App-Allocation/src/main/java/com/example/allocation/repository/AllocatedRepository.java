package com.example.allocation.repository;

import com.example.allocation.model.Allocated;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocatedRepository extends MongoRepository<Allocated, Integer> {
}
