package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.repository.StudRepository;

@RestController
@RequestMapping("/api/Put")
public class StudPutController {
	
	@Autowired
	private StudRepository studRepo;
	
	@PutMapping("/{id}")
	public String updatedStudent(
			@PathVariable int id,
			@RequestBody Student updatedStudent){
		
		Student selectStud = studRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("No Student Found:"+ id));
			
			selectStud.setName(updatedStudent.getName());
			selectStud.setCity(updatedStudent.getCity());
			selectStud.setAge(updatedStudent.getAge());
			selectStud.setRoll_no(updatedStudent.getRoll_no());
			selectStud.setSClass(updatedStudent.getSClass());
			selectStud.setSection(updatedStudent.getSection());
			
			studRepo.save(selectStud);
			return "Record Updated !!" ;
		}
	}