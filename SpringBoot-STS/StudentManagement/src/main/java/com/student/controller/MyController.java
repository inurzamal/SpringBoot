package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.dao.UserRepository;
import com.student.entities.User;

@Controller
public class MyController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		User user = new User();
		user.setName("Rahul");
		user.setEmail("nur.nielit18@gmail.com");
		user.setPassword("123");
		
		//repo.save(user);
		
		
		return "Data Saved into Database";
	}

}
