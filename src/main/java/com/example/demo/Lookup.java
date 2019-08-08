package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class Lookup {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void loadEmployees(){
        System.out.println("Loading Data......");
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            Employee employee = new Employee();
            employee.setName("P"+i);
            employee.setEmailAddress("P"+i+"@p.com");
            Address address = new Address();
            address.setPincode("50000"+i);
            address.setCountry("IND");
            address.setStateName("T"+i);
            address.setCity("H"+i);
            employee.setAddress(address);
            employees.add(employee);
        }
        employeeRepository.save(employees);
    }
}
