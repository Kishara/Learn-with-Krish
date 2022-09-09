package com.example.allocation.service;

import com.example.allocation.model.Available;
import com.example.allocation.repository.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AvailableService {

    @Autowired
    AvailableRepository availableRepository;

    @Autowired
    AllocationService allocatedService;


    public ResponseEntity<Available> saveAvailableFuel(Available available) {

        availableRepository.save(available);
        return ResponseEntity.status(HttpStatus.OK).body(available);

    }

    public Available getCapacity(String fuelType, int quantity,int orderId) {


        Available byFuelType = availableRepository.findByFuelType(fuelType);
        int availableCapacity = byFuelType.getQuantity();

        if(availableCapacity>=quantity){
            int newAvailableCapacity  = availableCapacity - quantity;
            byFuelType.setQuantity(newAvailableCapacity);
            saveAvailableFuel(byFuelType);
            allocatedService.getFromAvailable(orderId,fuelType,quantity);

        }

        return byFuelType;

    }
}
