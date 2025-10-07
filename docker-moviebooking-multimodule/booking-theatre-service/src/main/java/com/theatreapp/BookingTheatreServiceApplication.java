package com.theatreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class BookingTheatreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingTheatreServiceApplication.class, args);
	}

}
