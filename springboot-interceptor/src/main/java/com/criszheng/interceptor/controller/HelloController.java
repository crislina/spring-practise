package com.criszheng.interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cris
 * @date 21 Apr 2021
 * @version 1.0
 */
@RestController
public class HelloController {

	protected static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello greetings from springboot-interceptor";
	}
	
	@GetMapping("/getUserInfo")
	public String getUserInfo(String userId) {
		return "getUserInfo from userId=" + userId;
	}
}
