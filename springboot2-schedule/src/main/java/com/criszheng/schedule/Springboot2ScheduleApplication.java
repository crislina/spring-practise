package com.criszheng.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Springboot2ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2ScheduleApplication.class, args);
	}

}
