package com.example.ride_sharing_kafka.billingService;


import com.example.ride_sharing_kafka.common.RideEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillingConsumer {

    @KafkaListener(topics = "ride-events", groupId = "billing-service-group")
    public void listen(RideEvent event) {
        switch (event.getEventType()) {
            case "TRIP_STARTED":
                System.out.println("Billing: Prepare fare for ride " + event.getRideId());
                break;
            case "TRIP_ENDED":
                System.out.println("Billing: Finalize fare for ride " + event.getRideId());
                break;
        }
    }
}
