package com.criszheng.springbootjparediscache.service;

import com.criszheng.springbootjparediscache.entity.Person;

/**
 * @author Cris
 * @date 20 Apr 2021
 * @version 1.0
 */

public interface PersonService {
	Person save(String name,int age);
	
	Person get(Long id);
	
	Boolean expireCache(Long id);
}
