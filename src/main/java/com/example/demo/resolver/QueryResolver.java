package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entity.Employee;
import com.example.demo.model.Technology;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
	@Value("${technolgies-service}")
	String technologiesApi;
	
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
    
    public List<Employee> getEmployeeByEmail(String email) {
    	System.out.println("getEmployeeByEmail Invoked for email " + email);
    	return employeeRepository.findByEmailAddress(email);
	}
    
    public Long getEmployeesCount() {
    	System.out.println("getEmployeesCount Invoked");
    	return employeeRepository.count();
    }
    
    public List<Employee> getEmployeesByPinCode(String pincode){
    	System.out.println("getEmployeeByPinCode Invoked for " + pincode);
    	return employeeRepository.findByAddressPincode(pincode);
    }
    
    public List<Employee> getEmployeesByPaging(Integer start,Integer end){
    	System.out.println("getEmployeesByPaging Invoked for Starting " + start + " Ending "+ end);
    	return employeeRepository.findEmployeesByRange(start-1, end);
    }
    
    public List<Technology> getTechnologies(){
    	System.out.println("getTechnologies API "+ technologiesApi);
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<List<Technology>> response = 
    	restTemplate.exchange(technologiesApi,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Technology>>() {
        });
    	if(response.getStatusCode().equals(HttpStatus.OK)) {
    		return response.getBody();
    	}
    	else {
        	return new ArrayList<Technology>();
    	}
    }

}