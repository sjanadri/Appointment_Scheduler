package com.ssj.SchedulerApp.TrainerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class TrainerServiceApplication {

	public static void main(String[] args) {
	//	ConfigurableApplicationContext context =
		SpringApplication.run(TrainerServiceApplication.class, args);
	}
	
}
