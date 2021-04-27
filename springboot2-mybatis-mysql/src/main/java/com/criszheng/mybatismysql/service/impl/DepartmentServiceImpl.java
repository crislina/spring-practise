package com.criszheng.mybatismysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criszheng.mybatismysql.entity.Department;
import com.criszheng.mybatismysql.mapper.DepartmentMapper;
import com.criszheng.mybatismysql.service.DepartmentService;

/**
 * @author Cris
 * @date 27 Apr 2021
 * @version 1.0
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> listDepartment() {
		// TODO Auto-generated method stub
		return departmentMapper.listDepartment();
	}

	@Override
	public Department getDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentMapper.getDepartmentById(id);
	}

}
