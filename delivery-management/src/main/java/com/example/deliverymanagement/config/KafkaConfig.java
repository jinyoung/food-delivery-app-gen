package com.example.deliverymanagement.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Source.class)
public class KafkaConfig {
    // Configuration for Kafka producer and consumer
}