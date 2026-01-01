package com.example.ride_sharing_kafka.rideService;



import com.example.ride_sharing_kafka.common.RideEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class RideProducer {

    private final KafkaTemplate<String, RideEvent> kafkaTemplate;
    private static final String TOPIC = "ride-events";

    public void publishEvent(RideEvent event) {
        kafkaTemplate.send(TOPIC, event.getRideId(), event);
        System.out.println("Published event: " + event.getEventType() + " for ride: " + event.getRideId());
    }



    public void publishRideRequested(String rideId, String riderId) {
        RideEvent event = new RideEvent(
                "RIDE_REQUESTED",
                rideId,
                riderId,
                null,
                Instant.now().toEpochMilli()
        );
        kafkaTemplate.send(TOPIC, rideId, event);
        System.out.println("Published event: RIDE_REQUESTED for ride " + rideId);
    }

    public void publishDriverAssigned(String rideId, String riderId, String driverId) {
        RideEvent event = new RideEvent(
                "DRIVER_ASSIGNED",
                rideId,
                riderId,
                driverId,
                Instant.now().toEpochMilli()
        );
        kafkaTemplate.send(TOPIC, rideId, event);
        System.out.println("Published event: DRIVER_ASSIGNED for ride " + rideId);
    }
}
