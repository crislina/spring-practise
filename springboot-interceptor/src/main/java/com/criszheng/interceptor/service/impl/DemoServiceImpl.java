package com.criszheng.interceptor.service.impl;

import org.springframework.stereotype.Service;

import com.criszheng.interceptor.service.DemoService;

/**
 * @author Cris
 * @date 21 Apr 2021
 * @version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "hello from service layer";
	}

}
