package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsConsumer {

    @KafkaListener(
            topics = "my-topic",
            groupId = "analytics-group"
    )
    public void listenAnalytics(String message) {
        System.out.println("[ANALYTICS GROUP] Received: " + message);
    }
}