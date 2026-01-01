package com.citypass.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GatewayFallbackController {

    @GetMapping("/rideServiceFallback")
    public Map<String, Object> rideServiceFallback() {
        return Map.of(
                "status", "error",
                "service", "Ride Service",
                "message", "Ride Service is temporarily unavailable",
                "timestamp", System.currentTimeMillis()
        );
    }

    @GetMapping("/notificationServiceFallback")
    public Map<String, Object> notificationServiceFallback() {
        return Map.of(
                "status", "error",
                "service", "Notification Service",
                "message", "Notification Service is temporarily unavailable",
                "timestamp", System.currentTimeMillis()
        );
    }
}
