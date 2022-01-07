package com.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Test {
	
	@GetMapping("/example")
	public String staticFiles() {
		
		return "example";
	}

}
