package com.criszheng.mybatismysql.service;

import java.util.List;

import com.criszheng.mybatismysql.entity.Department;

/**
 * @author Cris
 * @date 27 Apr 2021
 * @version 1.0
 */

public interface DepartmentService {
	
	List<Department> listDepartment();
	
	Department getDepartmentById(Long id);
}
