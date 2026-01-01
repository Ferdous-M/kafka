package com.demo.producer;



import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

//    // 1️ Kafka Admin (required to create topics)
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(
//                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "localhost:9092"
//        );
//        return new KafkaAdmin(configs);
//    }

    // 2️ Topic 1
    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name("my-topic-2")
                .partitions(3)
                .replicas(1)
                .build();
    }

    // 3️ Topic 2
    @Bean
    public NewTopic newTopic() {
        return new NewTopic("my-new-topic-2", 2, (short) 1);
    }
}
