package com.criszheng.interceptor.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.criszheng.interceptor.service.DemoService;

/**
 * @author Cris
 * @date 21 Apr 2021
 * @version 1.0
 */
@Component
public class MyHttpInterceptor extends HandlerInterceptorAdapter {

	protected static Logger logger = LoggerFactory.getLogger(MyHttpInterceptor.class);
	
	@Autowired
	private DemoService demoService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		String method=request.getMethod();
		String url=request.getRequestURL().toString();
		String queryString="";
		
		Map<String,String[]> params=request.getParameterMap();
		for(String key:params.keySet()) {
			String[] values=params.get(key);
			for(int i=0;i<values.length;i++) {
				queryString+=key+"="+values[i]+"&";
			}
		}
		queryString=queryString.equals("")?null:queryString.substring(0,queryString.length()-1);
		logger.info("uri:"+uri);
		logger.info("method:"+method);
		logger.info("url:"+url);
		logger.info("query:"+queryString);
		
		if(uri.equals("/hello")) {
			return true;
		}
		
		logger.info("Inject service：demoService.sayHello()=" + this.demoService.sayHello());
		
		String userId=request.getParameter("userId");
		if(userId != null) {
			return true;
 
		}else{
			this.output(response, "{\n" 
					+ "\"code\": \"4001\",\n" 
					+ "\"message\": \"invalid parameter\"\n" 
					+ "}");
			return false;
		}
	}
	
	private void output(HttpServletResponse response, String result) throws Exception {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}
}
