package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.entity.Student;

@RestController
public class CrudController {
	
	@GetMapping(value="/greet")
	public String greet() {
		return "Welcome ...!";
	}
	
	@GetMapping(value="/greet1")
	public int greet1() {
		return 100;
	}
	
	@GetMapping(value="/greet2")
	public double greet2() {
		return 3.14;
	}
	
	@GetMapping(value="/studentdetails")
	public Student displayStudent() {
		return new Student("John",89);
	}
	
	@GetMapping(value="/employeedetails")
	public Employee displayEmployee() {
		return new Employee(1001,"Siva",20000);
	}

}
