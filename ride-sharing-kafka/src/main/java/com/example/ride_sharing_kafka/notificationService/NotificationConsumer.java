package com.example.ride_sharing_kafka.notificationService;


import com.example.ride_sharing_kafka.common.RideEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "ride-events", groupId = "notification-service-group")
    public void listen(RideEvent event) {
        switch (event.getEventType()) {
            case "DRIVER_ASSIGNED":
                System.out.println("Notify Rider: Driver " + event.getDriverId() + " assigned for ride " + event.getRideId());
                break;
            case "TRIP_STARTED":
                System.out.println("Notify Rider: Trip started for ride " + event.getRideId());
                break;
            case "TRIP_ENDED":
                System.out.println("Notify Rider: Trip ended for ride " + event.getRideId());
                break;
        }
    }
}
