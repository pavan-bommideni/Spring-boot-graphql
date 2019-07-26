package com.example.demo.respository;

import com.example.demo.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByEmailAddress(String email);

}
