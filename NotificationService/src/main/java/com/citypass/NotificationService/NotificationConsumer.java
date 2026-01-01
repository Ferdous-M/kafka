package com.citypass.NotificationService;



import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;
    private final RideServiceClient rideServiceClient;

    @KafkaListener(
            topics = "ride-events",
            groupId = "notification-service-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(RideEvent event) {
        switch (event.getEventType()) {
            case "DRIVER_ASSIGNED":
            case "TRIP_STARTED":
            case "TRIP_ENDED":
                // Fetch extra ride details from RideService
                RideDetails details = rideServiceClient.getRideDetails(event.getRideId());

                String message;
                switch (event.getEventType()) {
                    case "DRIVER_ASSIGNED":
                        message = "Driver " + details.getDriverName() + " assigned for your ride";
                        break;
                    case "TRIP_STARTED":
                        message = "Your trip has started";
                        break;
                    case "TRIP_ENDED":
                        message = "Your trip has ended";
                        break;
                    default:
                        message = "";
                }

                notificationService.addNotification(
                        new Notification(event.getRiderId(), event.getRideId(), message)
                );
                break;

            default:
                // Ignore other events
        }
    }
}
