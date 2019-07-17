package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.respository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeQueryResolver implements GraphQLResolver<Employee> {

    public EmployeeQueryResolver(){
        System.out.println("EmployeeQueryResolver Intialised");
    }

    @Autowired
    private AddressRepository addressRepository;

    public Address getAddress(Employee employee){
        System.out.println("getAddress for Employee Invoked");
        return addressRepository.findOne(employee.getAddress().getId());
    }
}
