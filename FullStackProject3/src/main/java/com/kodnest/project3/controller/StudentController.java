package com.kodnest.project3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kodnest.project3.entity.Student;
import com.kodnest.project3.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studService;

	@GetMapping(value="/displayStudent")
	public List<Student> getStudents() {
		return studService.getStudents();
	}
	
	@PostMapping(value = "/insertStudent")
	public void insertStudent(@RequestBody Student s) {
		studService.insertStudent(s);
	}
	
	@PutMapping(value = "/updateStudent/{id}")
	public void updateStudent(@PathVariable int id,@RequestBody Student s) {
		System.out.println(id);
		System.out.println(s);
		studService.updateStudent(id,s);
	}
	
	@DeleteMapping(value = "/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		studService.deleteStudent(id);
	}
	
	
}
