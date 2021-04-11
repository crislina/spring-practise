package com.criszheng.springbootexception.entity;

import java.io.Serializable;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

public class User implements Serializable{

	private Long id;
	private String username;
	private String accountName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
}
