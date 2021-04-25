package com.criszheng.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.criszheng.schedule.service.DemoService;

/**
 * @author Cris
 * @date 24 Apr 2021
 * @version 1.0
 */
@Component
public class ScheduledTasks {

	protected static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private DemoService demoService;
	
	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void scheduledTask1() {
		logger.info("scheduled task1"+demoService.sayHello());
	}
	
	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void scheduledTask2() {
		logger.info("scheduled task2");
	}
	
	@Scheduled(cron="*/10 * * * * *")
	public void scheduledTask3() {
		logger.info("scheduled task3 based on cron");
	}
	
	@Async
	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void scheduledTask4() {
		logger.info("scheduled task4 with Async");
	}
}
