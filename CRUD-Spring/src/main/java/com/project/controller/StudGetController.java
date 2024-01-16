package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.repository.StudRepository;

@RestController
@RequestMapping("/api")
public class StudGetController {
		
	
	@Autowired
	private StudRepository studRepo;
	
//********************** Get method ***********************//	
	@GetMapping("/get")
	public List<Student> getStudent()
	{
		return studRepo.findAll();
	}
	
//********************** Get By ID ***********************//	
	@GetMapping("/{id}")
	public Optional<Student> getByID(@PathVariable("id") int id)
	{
		return studRepo.findById(id);
//		return studRepo.findById(id)
//				.orElseThrow(() -> new RuntimeException("No Student Found with id:" + id));
	}
	
//********************** Get By Name ***********************//
	
	@GetMapping("/name")
	public List<Student> getByName(@RequestParam("name") String name)
	{
		return studRepo.findByName(name);
	}
	
//********************** Get By Class ***********************//
	
		@GetMapping("/sClass")
		public List<Student> getByStanderd(@RequestParam("sClass") String sClass)
		{
			return studRepo.findByStudentClass(sClass);
		}
}
