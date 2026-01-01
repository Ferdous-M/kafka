package com.citypass.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                // Ride Service Route
                .route("ride-service", r -> r.path("/rides/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(c -> c
                                        .setName("rideServiceCircuitBreaker")
                                        .setFallbackUri("forward:/rideServiceFallback")))
                        .uri("lb://RIDE-SERVICE"))

                // Notification Service Route
                .route("notification-service", r -> r.path("/notifications/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(c -> c
                                        .setName("notificationServiceCircuitBreaker")
                                        .setFallbackUri("forward:/notificationServiceFallback")))
                        .uri("lb://NOTIFICATION-SERVICE"))

                .build();
    }
}
