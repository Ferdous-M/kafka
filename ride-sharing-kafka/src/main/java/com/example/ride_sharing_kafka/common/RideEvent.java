package com.example.ride_sharing_kafka.common;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideEvent {
    private String eventType; // RIDE_REQUESTED, DRIVER_ASSIGNED, etc.
    private String rideId;
    private String riderId;
    private String driverId;
    private long timestamp;
}
