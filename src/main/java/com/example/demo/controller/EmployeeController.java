package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@GetMapping("/test1")
	public String getMessage(){
	return "Hello Amigo 1 !";	
	}

	@GetMapping("/test2")
	public String getMessage1(){
	return "Hello Amigo 2 !";	
	}

}
