package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

	
	//REST client - app -- postman 
	@PostMapping("/signup")
	public String saveUser() {
		return "User Save";
	}
}
