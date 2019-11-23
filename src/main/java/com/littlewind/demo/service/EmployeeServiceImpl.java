package com.littlewind.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlewind.demo.entity.Employee;
import com.littlewind.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee finByUserName(String username) {
		Employee result;
		result = employeeRepository.findByUsername(username);
		return result;
	}

}
