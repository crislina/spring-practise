package com.criszheng.interceptor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.criszheng.interceptor.interceptor.MyHttpInterceptor;

/**
 * @author Cris
 * @date 21 Apr 2021
 * @version 1.0
 */

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Bean
	public HandlerInterceptor getMyInterceptor() {
		return new MyHttpInterceptor();
	}
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
