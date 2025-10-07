package com.moviecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class BookingMoviecatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMoviecatalogServiceApplication.class, args);
	}

}
