package com.kodnest.project3.service;

import java.util.List;

import com.kodnest.project3.entity.Student;

public interface StudentService {

	List<Student> getStudents();

	void insertStudent(Student s);

	void updateStudent(int id, Student s);

	void deleteStudent(int id);

}
