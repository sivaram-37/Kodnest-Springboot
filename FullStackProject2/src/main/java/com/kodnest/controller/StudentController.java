package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.entity.Student;
import com.kodnest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(value="/students")
	public List<Student> getStudent() {
		return studentService.getStudent();
	}
	
	@GetMapping(value="/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping(value="/students/post")
	public void postStudentById(@RequestBody Student s) {
		System.out.println(s);
		studentService.postStudentById(s);
	}
	
	@DeleteMapping(value = "/students/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		System.out.println(id);
		studentService.deleteStudentById(id);
	}
	
	@PutMapping(value = "/students/update/{id}")
	public void updateStudent(@PathVariable int id,@RequestBody Student s) {
		System.out.println(id);
		System.out.println(s);
		studentService.updateStudent(id,s);
	}

}
