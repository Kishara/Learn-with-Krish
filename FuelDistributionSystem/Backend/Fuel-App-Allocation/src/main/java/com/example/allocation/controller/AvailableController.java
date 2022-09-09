package com.example.allocation.controller;

import com.example.allocation.model.Available;
import com.example.allocation.service.AvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailableController {

    @Autowired
    AvailableService availableService;


    @PostMapping("/saveavailable")
    public ResponseEntity<Available> saveAvailableFuel(@RequestBody Available available) {
        return availableService.saveAvailableFuel(available);
    }
}
