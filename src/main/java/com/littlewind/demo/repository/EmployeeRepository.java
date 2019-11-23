package com.littlewind.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.littlewind.demo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, String>{
	Employee getOne(String id);
	Employee findByUsername(String username);
}
