package com.example.demo.mutations;

import java.util.Objects;

import javax.transaction.Transactional;

import com.example.demo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeInfoModel;
import com.example.demo.respository.EmployeeRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	public MutationResolver() {
		System.out.println("MutationResolver Intialised");
	}

	@Autowired
    private EmployeeRepository employeeRepository;

	@Transactional
	public Employee createEmployee(EmployeeInfoModel employeeModel) {
		System.out.println("createEmployee Invoked");
		Employee employee = new Employee();
		employee.setName(employeeModel.getName());
		employee.setEmailAddress(employeeModel.getEmailAddress());
		Address address = new Address();
		address.setCity(employeeModel.getCity());
		address.setStateName(employeeModel.getStateName());
		address.setCountry(employeeModel.getCountry());
		address.setPincode(employeeModel.getPincode());
		employee.setAddress(address);
		employee = employeeRepository.save(employee);
		return employee;
	}

	public Boolean deleteEmployee(int id) {
		System.out.println("deleteEmployee Invoked");
		Boolean status = Boolean.FALSE;
		Employee employee = employeeRepository.findOne(id);
		if(Objects.nonNull(employee)) {
			employeeRepository.delete(id);
			status = Boolean.TRUE;
		}
		return status;
	}


}
