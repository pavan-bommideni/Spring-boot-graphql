package com.example.demo.mutations;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeModel;
import com.example.demo.respository.EmployeeRespository;

@Component
public class MutationResolver implements GraphQLMutationResolver {
	
	public MutationResolver() {
		System.out.println("MutationResolver Intialised");
	}
	
	@Autowired
	EmployeeRespository employeeRespository;
	
	@Transactional
	public Employee createEmployee(EmployeeModel employeeModel) {
		System.out.println("createEmployee Invoked");
		Employee employee = new Employee();
		employee.setName(employeeModel.getName());
		employee.setEmailAddress(employeeModel.getEmailAddress());
		employee = employeeRespository.save(employee);
		return employee;
	}
	
	public Boolean deleteEmployee(int id) {
		System.out.println("deleteEmployee Invoked");
		Boolean status = Boolean.FALSE;
		Employee employee = employeeRespository.findOne(id);
		if(Objects.nonNull(employee)) {
			employeeRespository.delete(id);
			status = Boolean.TRUE;
		}
		return status;
	}

	
}
