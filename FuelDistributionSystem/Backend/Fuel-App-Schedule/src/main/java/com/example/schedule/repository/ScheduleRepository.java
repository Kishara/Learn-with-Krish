package com.example.schedule.repository;

import com.example.schedule.model.Scheduled;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Scheduled, Integer> {
}
