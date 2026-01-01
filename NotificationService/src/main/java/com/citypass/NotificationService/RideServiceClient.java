package com.citypass.NotificationService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ride-service", url = "http://localhost:8080")
public interface RideServiceClient {

    @GetMapping("/rides/{rideId}/details")
    RideDetails getRideDetails(@PathVariable String rideId);
}
