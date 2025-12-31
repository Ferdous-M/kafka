package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ChatConsumer {

    @KafkaListener(
            topics = "my-topic",
            groupId = "chat-group"
    )
    public void listenChat(String message) {
        System.out.println("[CHAT GROUP] Received: " + message);
    }
}
