package com.criszheng.schedule.service.impl;

import org.springframework.stereotype.Service;

import com.criszheng.schedule.service.DemoService;

/**
 * @author Cris
 * @date 24 Apr 2021
 * @version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello from Demo Service";
	}

}
