package com.boot.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	 
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name, String city);
	
	public List<User> findByNameStartingWith(String prefix);
	
//	public List<User> findByAgeLessThan(int age);
//	public List<User> findByAgeGreaterThanEqual(int age);

}
