package com.boot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.boot.jpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	 
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name, String city);
	
	public List<User> findByNameStartingWith(String prefix);
	
//	public List<User> findByAgeLessThan(int age);
//	public List<User> findByAgeGreaterThanEqual(int age);
	
	//JPQL Query or Native Query
	
	@Query("select u from User u where u.name=:n")
	public List<User> getUserByName(@Param("n") String name);
		
	@Query("select u from User u where u.name=:n and u.city=:c")
	public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c")String city);
		
	@Query(value="select * from user", nativeQuery=true)
	public List<User> getUsers();

}
