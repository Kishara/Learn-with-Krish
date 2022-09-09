package com.example.allocation.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String PROJECTTOPIC = "allocationTopic";

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(PROJECTTOPIC)
                .build();
    }

}
