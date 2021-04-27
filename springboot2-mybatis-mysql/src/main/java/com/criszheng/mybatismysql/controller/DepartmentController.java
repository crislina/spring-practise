package com.criszheng.mybatismysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.criszheng.mybatismysql.entity.Department;
import com.criszheng.mybatismysql.service.DepartmentService;

/**
 * @author Cris
 * @date 27 Apr 2021
 * @version 1.0
 */

@RestController
@RequestMapping("/v1/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/departments",method=RequestMethod.GET)
	public List<Department> listDepartment(){
		return departmentService.listDepartment();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Department getDepartmentById(@PathVariable("id") Long id) {
		return departmentService.getDepartmentById(id);
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello greetings from spring-boot2-mybatis-mysql";
	}
	
}
