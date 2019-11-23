package com.littlewind.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
	@Id
	String id;
	
	String username;
	
	String password;
	
	String role;
}
