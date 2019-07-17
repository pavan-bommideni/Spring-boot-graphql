package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entity.Employee;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
	public QueryResolver() {
		System.out.println("QueryResolver Intialised");
	}

	@Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
    	System.out.println("getEmployees Invoked");
        return employeeRepository.findAll();
    }
    
    public Employee getEmployee(int id) {
    	System.out.println("getEmployee Invoked for id " + id);
    	return employeeRepository.findOne(id);
	}

}