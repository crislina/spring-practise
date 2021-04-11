package com.criszheng.springbootexception.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.criszheng.springbootexception.exception.IllegalPropertiesException;
import com.criszheng.springbootexception.exception.NullOrEmptyException;
import com.criszheng.springbootexception.exception.SessionNotFoundException;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

@RestController
public class UserController {
	
	@RequestMapping(value="/user/{param}",method=RequestMethod.GET)
	public ResponseEntity<?> save(@PathVariable String param) throws Exception{
		if("a".equals(param)) {
			throw new IllegalPropertiesException();
		}
		if("b".equals(param)){
            throw new SessionNotFoundException();
        }
        if("c".equals(param)){
            throw new NullOrEmptyException();
        }
        return ResponseEntity.ok("Successful");
	}
	
}
