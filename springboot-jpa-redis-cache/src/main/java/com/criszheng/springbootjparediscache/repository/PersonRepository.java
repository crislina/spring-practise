package com.criszheng.springbootjparediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criszheng.springbootjparediscache.entity.Person;

/**
 * @author Cris
 * @date 20 Apr 2021
 * @version 1.0
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByName(String name);

}
