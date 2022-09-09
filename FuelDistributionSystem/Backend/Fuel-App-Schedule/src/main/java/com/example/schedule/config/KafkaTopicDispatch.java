package com.example.schedule.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicDispatch {
    public static final String PROJECTTOPIC = "scheduleDispatchTopic";

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(PROJECTTOPIC)
                .build();
    }
}
