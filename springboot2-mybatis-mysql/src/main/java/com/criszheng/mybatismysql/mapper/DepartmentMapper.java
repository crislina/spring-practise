package com.criszheng.mybatismysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.criszheng.mybatismysql.entity.Department;

/**
 * @author Cris
 * @date 27 Apr 2021
 * @version 1.0
 */
@Mapper
public interface DepartmentMapper {
	
	public List<Department> listDepartment();
	
	public Department getDepartmentById(Long id);
	
}
