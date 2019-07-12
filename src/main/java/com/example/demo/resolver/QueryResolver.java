package com.example.demo.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entity.Employee;
import com.example.demo.respository.EmployeeRespository;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
	public QueryResolver() {
		System.out.println("QueryResolver Intialised");
	}
	@Autowired
    private EmployeeRespository employeeRespository;
  

    public List<Employee> getEmployees() {
    	System.out.println("getEmployees Invoked");
        return employeeRespository.findAll();
    }

}