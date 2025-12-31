package com.example.ride_sharing_kafka.driverService;

import com.example.ride_sharing_kafka.common.RideEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class DriverConsumer {

    private final KafkaTemplate<String, RideEvent> kafkaTemplate;
    private static final String TOPIC = "ride-events";

    @KafkaListener(topics = TOPIC, groupId = "driver-service-group")
    public void listen(RideEvent event) {
        if ("RIDE_REQUESTED".equals(event.getEventType())) {
            System.out.println("DriverService: Ride requested: " + event.getRideId());

            // Simulate driver assignment
            String driverId = "driver-" + event.getRideId();
            RideEvent assigned = new RideEvent("DRIVER_ASSIGNED", event.getRideId(), event.getRiderId(), driverId, Instant.now().toEpochMilli());
            kafkaTemplate.send(TOPIC, event.getRideId(), assigned);

            System.out.println("DriverService: Driver assigned: " + driverId + " for ride: " + event.getRideId());
        }
    }
}
