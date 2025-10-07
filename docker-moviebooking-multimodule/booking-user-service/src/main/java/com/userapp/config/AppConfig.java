package com.userapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	//create a bean of ModelMapper which is a inbuilt a class
		@Bean
		ModelMapper mapper() {
			return new ModelMapper();
		}
}
