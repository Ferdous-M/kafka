package com.citypass.NotificationService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDetails {
    private String rideId;
    private String riderName;
    private String driverName;
    private String pickupLocation;
    private String dropLocation;
}
