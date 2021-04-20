package com.criszheng.springbootjparediscache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.criszheng.springbootjparediscache.service.PersonService;
import com.criszheng.springbootjparediscache.utils.CommonResult;


/**
 * @author Cris
 * @date 20 Apr 2021
 * @version 1.0
 */

@RestController
public class RedisController {

	protected static Logger logger = LoggerFactory.getLogger(RedisController.class);
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="person",method=RequestMethod.POST)
	public CommonResult createPerson(@RequestParam String name,@RequestParam int age) {
		return CommonResult.success(personService.save(name, age));
	}
	
	@RequestMapping(value="person",method=RequestMethod.GET)
	public CommonResult getPerson(@RequestParam Long id) {
		return CommonResult.success(personService.get(id));
	}
	
	@RequestMapping(value="person/expiry",method=RequestMethod.GET)
	public CommonResult expirePerson(@RequestParam Long id) {
		return CommonResult.success(personService.expireCache(id));
	}
}
