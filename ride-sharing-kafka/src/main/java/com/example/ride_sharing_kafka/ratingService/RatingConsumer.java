package com.example.ride_sharing_kafka.ratingService;


import com.example.ride_sharing_kafka.common.RideEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RatingConsumer {

    @KafkaListener(topics = "ride-events", groupId = "rating-service-group")
    public void listen(RideEvent event) {
        if ("RIDE_RATED".equals(event.getEventType())) {
            System.out.println("Rating: Ride " + event.getRideId() + " rated by rider " + event.getRiderId());
        }
    }
}
