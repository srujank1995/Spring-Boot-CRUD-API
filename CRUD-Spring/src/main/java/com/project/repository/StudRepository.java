package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Student;

public interface StudRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByName(String name);
	List<Student> findByStudentClass(String sClass);
	List<Student> deleteByName(String name);
}
