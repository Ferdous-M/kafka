package com.example.ride_sharing_kafka.rideService;

import com.example.ride_sharing_kafka.common.RideEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RestController
@RequestMapping("/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideProducer producer;

    @PostMapping("/request")
    public String requestRide(@RequestParam String rideId, @RequestParam String riderId) {
        RideEvent event = new RideEvent("RIDE_REQUESTED", rideId, riderId, null, Instant.now().toEpochMilli());
        producer.publishEvent(event);
        return "Ride requested: " + rideId;
    }

    @PostMapping("/start")
    public String startRide(@RequestParam String rideId, @RequestParam String driverId) {
        RideEvent event = new RideEvent("TRIP_STARTED", rideId, null, driverId, Instant.now().toEpochMilli());
        producer.publishEvent(event);
        return "Trip started: " + rideId;
    }

    @PostMapping("/end")
    public String endRide(@RequestParam String rideId, @RequestParam String driverId) {
        RideEvent event = new RideEvent("TRIP_ENDED", rideId, null, driverId, Instant.now().toEpochMilli());
        producer.publishEvent(event);
        return "Trip ended: " + rideId;
    }

    @PostMapping("/rate")
    public String rateRide(@RequestParam String rideId, @RequestParam String riderId) {
        RideEvent event = new RideEvent("RIDE_RATED", rideId, riderId, null, Instant.now().toEpochMilli());
        producer.publishEvent(event);
        return "Ride rated: " + rideId;
    }

}
