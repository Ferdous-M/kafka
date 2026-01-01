package com.example.ride_sharing_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.ride_sharing_kafka")
public class RideSharingKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideSharingKafkaApplication.class, args);
	}

}
