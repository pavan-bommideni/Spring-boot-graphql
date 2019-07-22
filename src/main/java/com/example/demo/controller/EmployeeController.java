package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@GetMapping("/user1")
	public String getMessage(){
	return "Hello Amigo 1 !";	
	}

@GetMapping("/user2")
	public String getMessage2(){
	return "Hello Amigo 2 !";	
	}

  @GetMapping("/user3")
	public String getMessage3(){
	return "Hello Amigo 3!";	
	}

}
