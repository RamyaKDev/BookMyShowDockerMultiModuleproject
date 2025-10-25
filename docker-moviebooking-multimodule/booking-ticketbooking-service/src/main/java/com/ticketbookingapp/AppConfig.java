package com.ticketbookingapp;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	//creating a bean for inbuilt class modelmapper
	@Bean
	ModelMapper mapper(){
	return new ModelMapper();
}
	//creating bean for RestTemplate
	//@LoadBalanced
	  @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
