package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
