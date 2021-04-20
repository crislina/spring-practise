package com.criszheng.springbootjparediscache.service.impl;

import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.criszheng.springbootjparediscache.controller.RedisController;
import com.criszheng.springbootjparediscache.entity.Person;
import com.criszheng.springbootjparediscache.repository.PersonRepository;
import com.criszheng.springbootjparediscache.service.PersonService;
import com.criszheng.springbootjparediscache.utils.RedisUtil;

/**
 * @author Cris
 * @date 20 Apr 2021
 * @version 1.0
 */

@Service
public class PersonServiceImpl implements PersonService {

	protected static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public Person save(String name, int age) {
		// TODO Auto-generated method stub
		Person person=new Person();
		person.setName(name);
		person.setAge(age);
		Person output=personRepository.save(person);
		RedisUtil.set(this.redisTemplate, Person.class.toString()+":"+output.getId(), output);
		logger.info("save person to redis cache");
		return output;
	}

	@Override
	public Person get(Long id) {
		// TODO Auto-generated method stub
		Person person=(Person) RedisUtil.get(this.redisTemplate, Person.class.toString()+":"+id);
		if(person==null) {
			Optional<Person> personOpt=personRepository.findById(id);
			logger.info("retrieve from database");
			if(personOpt.isPresent()) {
				person=personOpt.get();
				RedisUtil.set(this.redisTemplate, Person.class.toString()+":"+id, person,30);
			}
		}else {
			logger.info("retrieve from redis cache");
		}
		return person;
	}

	@Override
	public Boolean expireCache(Long id) {  //expire in 5 seconds
		// TODO Auto-generated method stub
		return RedisUtil.expire(redisTemplate, Person.class.toString()+":"+id, 5);
	}

}
