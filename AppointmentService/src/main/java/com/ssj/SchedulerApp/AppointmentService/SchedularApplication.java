package com.ssj.SchedulerApp.AppointmentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SchedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedularApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
