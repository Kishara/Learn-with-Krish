package com.example.allocation.service;

import com.example.allocation.config.KafkaTopicConfig;
import com.example.allocation.model.Allocated;
import com.example.allocation.repository.AllocatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {

    @Autowired
    AllocatedRepository allocatedRepository;

    @Autowired
    KafkaTemplate<String, Allocated> kafkaTemplate;

    public Allocated saveAllocated(Allocated allocated) {

        kafkaTemplate.send(KafkaTopicConfig.PROJECTTOPIC,allocated);
        return allocatedRepository.save(allocated);
    }

    public Allocated getFromAvailable(int orderId, String fuelType, int quantity) {
        Allocated allocated = new Allocated();
        allocated.setOrderId(orderId);
        allocated.setFuelType(fuelType);
        allocated.setQuantity(quantity);
        return saveAllocated(allocated);


    }
}
