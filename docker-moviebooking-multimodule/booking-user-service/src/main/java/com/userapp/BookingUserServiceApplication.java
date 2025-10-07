package com.userapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class BookingUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingUserServiceApplication.class, args);
	}

}
