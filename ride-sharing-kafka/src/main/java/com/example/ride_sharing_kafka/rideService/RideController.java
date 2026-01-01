package com.example.ride_sharing_kafka.rideService;

import com.example.ride_sharing_kafka.common.RideEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideProducer producer;

   // private final RideProducer rideProducer;


    // Rider requests a ride
//    @PostMapping("/request")
//    public String requestRide(@RequestParam String rideId, @RequestParam String riderId) {
//        rideId = rideId.trim();
//        riderId = riderId.trim();
//
//        // Publish ride requested event
//        producer.publishRideRequested(rideId, riderId);
//
//        // Simulate assigning driver immediately
//        producer.publishDriverAssigned(rideId, riderId, "driver-" + rideId);
//
//        return "Ride requested: " + rideId;
//    }

    @PostMapping("/request")
    public String requestRideOld(@RequestParam String rideId, @RequestParam String riderId) {
        // Trim inputs to remove extra spaces/newlines
        rideId = rideId.trim();
        riderId = riderId.trim();

        RideEvent event = new RideEvent(
                "RIDE_REQUESTED",
                rideId,
                riderId,
                null,
                Instant.now().toEpochMilli()
        );
        producer.publishEvent(event);
        System.out.println("Published event: RIDE_REQUESTED for ride: " + rideId);
        return "Ride requested: " + rideId;
    }

    @PostMapping("/start")
    public String startRide(@RequestParam String rideId, @RequestParam String driverId) {
        rideId = rideId.trim();
        driverId = driverId.trim();

        RideEvent event = new RideEvent(
                "TRIP_STARTED",
                rideId,
                null,
                driverId,
                Instant.now().toEpochMilli()
        );
        producer.publishEvent(event);
        System.out.println("Published event: TRIP_STARTED for ride: " + rideId);
        return "Trip started: " + rideId;
    }

    @PostMapping("/end")
    public String endRide(@RequestParam String rideId, @RequestParam String driverId) {
        rideId = rideId.trim();
        driverId = driverId.trim();

        RideEvent event = new RideEvent(
                "TRIP_ENDED",
                rideId,
                null,
                driverId,
                Instant.now().toEpochMilli()
        );
        producer.publishEvent(event);
        System.out.println("Published event: TRIP_ENDED for ride: " + rideId);
        return "Trip ended: " + rideId;
    }

    @PostMapping("/rate")
    public String rateRide(@RequestParam String rideId, @RequestParam String riderId) {
        rideId = rideId.trim();
        riderId = riderId.trim();

        RideEvent event = new RideEvent(
                "RIDE_RATED",
                rideId,
                riderId,
                null,
                Instant.now().toEpochMilli()
        );
        producer.publishEvent(event);
        System.out.println("Published event: RIDE_RATED for ride: " + rideId);
        return "Ride rated: " + rideId;
    }
}
