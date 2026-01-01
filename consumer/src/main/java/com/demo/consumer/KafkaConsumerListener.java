package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {
    @KafkaListener(topics = {"my-topic", "new-topic"}, groupId = "demo-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
