package com.example.demo.respository;

import com.example.demo.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByEmailAddress(String email);
	
	List<Employee> findByAddressPincode(String pincode);
	
	@Query(value = "Select * from Employee limit ?1,?2",nativeQuery = true)
	List<Employee> findEmployeesByRange(Integer start,Integer end);

}
