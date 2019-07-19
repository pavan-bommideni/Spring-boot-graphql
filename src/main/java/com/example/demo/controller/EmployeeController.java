package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController("/api")
public class EmployeeController {
	
	@GetMapping("/test")
	public String getMessage(){
	return "Hello Testing Commit";	
	}
	


}
