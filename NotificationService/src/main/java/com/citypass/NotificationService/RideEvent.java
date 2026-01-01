package com.citypass.NotificationService;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideEvent {
    private String eventType;
    private String rideId;
    private String riderId;
    private String driverId;
    private long timestamp;
}
