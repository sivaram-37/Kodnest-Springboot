package com.kodnest.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Student;
import com.kodnest.repository.StudentRepository;
import com.kodnest.service.StudentService;
 
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudent(){
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public void postStudentById(Student s) {
		studentRepository.save(s);
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void updateStudent(int id, Student updateS) {
		Optional<Student> existS = studentRepository.findById(id);
		if(existS.isPresent()) {
			Student student = existS.get();
			student.setSname(updateS.getSname());
			studentRepository.save(student);
			System.out.println("Update Successfully");
		}
		else {
			System.out.println("Record not found");
		}
	}

	

}
