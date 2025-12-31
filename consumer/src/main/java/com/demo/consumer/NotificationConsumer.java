package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @KafkaListener(
            topics = "my-topic",
            groupId = "notification-group"
    )
    public void listenNotification(String message) {
        System.out.println("[NOTIFICATION GROUP] Received: " + message);
    }
}