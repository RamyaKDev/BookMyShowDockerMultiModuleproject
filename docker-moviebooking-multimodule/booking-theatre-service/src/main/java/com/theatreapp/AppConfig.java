package com.theatreapp;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	//creating a bean for inbuilt class modelmapper
	@Bean
	ModelMapper mapper(){
	return new ModelMapper();
}
}
