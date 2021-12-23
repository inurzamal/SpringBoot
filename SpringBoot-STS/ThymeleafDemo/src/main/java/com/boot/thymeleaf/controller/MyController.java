package com.boot.thymeleaf.controller;

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
		
		return "iterate.html";
	}

}
