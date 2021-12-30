package com.boot.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about(Model model) {		
		model.addAttribute("name", "Nurzamal Islam");		
		return "about";
	}
	
	@GetMapping("/iteration")
	public String iteration(Model m) {
		
		List<String> list = List.of("Sumi","Shibani","Rani");
		m.addAttribute("names", list);
		
		return "iterate";
	}
	
	@GetMapping("/conditional")
	public String conditionalTest(Model m) {
		
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "F");		
		List<Integer> numbers = List.of(5,6,7,8,9,10);		
		m.addAttribute("mylist", numbers);		
		return "condition";
	}
	
	@GetMapping("/fragment")
	public String fragmentTest(Model m){
		
		m.addAttribute("title", "Learning Spring Boot");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		
		return "contact";
		
	}
	
	@GetMapping("/services")
	public String serviceHandler() {
		return "services";
	}

}
