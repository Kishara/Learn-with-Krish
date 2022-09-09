package com.example.schedule.service;

import com.example.schedule.config.KafkaTopicConfig;
import com.example.schedule.config.KafkaTopicDispatch;
import com.example.schedule.model.Scheduled;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    KafkaTemplate<String, Scheduled> kafkaTemplate;

    public Scheduled saveSchedule(Scheduled scheduled) {
        kafkaTemplate.send(KafkaTopicConfig.PROJECTTOPIC,scheduled);
        kafkaTemplate.send(KafkaTopicDispatch.PROJECTTOPIC,scheduled);
        return scheduleRepository.save(scheduled);
    }

    public Scheduled deliveryDate(int orderId) {

        Scheduled scheduled = new Scheduled();
        scheduled.setOrderId(orderId);
        scheduled.setDate(LocalDate.now().plusDays(1).toString());
        saveSchedule(scheduled);

        return scheduled;
    }

    public List<Scheduled> getAllDeliveryDates() {
        return scheduleRepository.findAll();

    }
}
