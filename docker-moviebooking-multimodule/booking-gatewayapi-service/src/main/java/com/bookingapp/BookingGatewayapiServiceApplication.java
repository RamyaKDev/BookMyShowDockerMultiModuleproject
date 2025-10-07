package com.bookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class BookingGatewayapiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingGatewayapiServiceApplication.class, args);
	}

}
