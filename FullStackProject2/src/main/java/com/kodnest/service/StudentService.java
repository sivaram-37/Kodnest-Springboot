package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.Student;


public interface StudentService{
	List<Student> getStudent();

	Student getStudentById(int id);

	void postStudentById(Student s);

	void deleteStudentById(int id);

	void updateStudent(int id, Student s);

	

	
}