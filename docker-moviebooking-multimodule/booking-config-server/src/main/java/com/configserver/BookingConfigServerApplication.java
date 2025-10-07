package com.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BookingConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingConfigServerApplication.class, args);
	}

}
