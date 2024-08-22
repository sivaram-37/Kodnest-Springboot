package com.kodnest.project3.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.project3.entity.Student;
import com.kodnest.project3.repository.StudentRepository;
import com.kodnest.project3.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studRepository;

	@Override
	public List<Student> getStudents() {
		return studRepository.findAll();
	}

	@Override
	public void insertStudent(Student s) {
		studRepository.save(s);
		System.out.println("Insert Successfully !!!");
	}

	@Override
	public void updateStudent(int id, Student updateStudent) {
		Optional<Student> existStudent = studRepository.findById(id);
		if(existStudent.isPresent()) {
			Student student = existStudent.get();
			student.setSname(updateStudent.getSname());
			studRepository.save(student);
			System.out.println("Update Successfully !!!");
		}
		else {
			System.out.println("Record does not exist !!!");
		}
	}

	@Override
	public void deleteStudent(int id) {
		Optional<Student> exist = studRepository.findById(id);
		if(exist.isPresent()) {
			studRepository.deleteById(id);
			System.out.println("Deleted Successfully !!!");
		}
		else {
			System.out.println("Record does not exist !!!");
		}
	}
}
