package com.example.ride_sharing_kafka.rideService;



import com.example.ride_sharing_kafka.common.RideEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideProducer {

    private final KafkaTemplate<String, RideEvent> kafkaTemplate;
    private static final String TOPIC = "ride-events";

    public void publishEvent(RideEvent event) {
        kafkaTemplate.send(TOPIC, event.getRideId(), event);
        System.out.println("Published event: " + event.getEventType() + " for ride: " + event.getRideId());
    }
}
