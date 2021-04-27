package com.criszheng.mybatismysql.entity;

import java.io.Serializable;

/**
 * @author Cris
 * @date 27 Apr 2021
 * @version 1.0
 */

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3533724408829954732L;

	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
