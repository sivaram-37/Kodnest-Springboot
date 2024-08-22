package com.kodnest.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kodnest.project3.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
