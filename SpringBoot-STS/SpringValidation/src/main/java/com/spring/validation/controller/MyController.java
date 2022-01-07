package com.spring.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.validation.entities.User;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm(Model m) {
		m.addAttribute("u", new User());
		return "form";
	}
	
	@PostMapping("/process")
	public String formHandler(@Valid @ModelAttribute("u") User user, BindingResult result) throws Exception{
		
		if(result.hasErrors()) 
		{
			//System.out.println(result);
			return "form";
		}
		
		//System.out.println(user);
		return "success";
	}

}
