package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.repository.StudRepository;

@RestController
@RequestMapping("/api/delete")
public class StudDeleteController {
	
	@Autowired
	private StudRepository studRepo;
	
	@DeleteMapping("/id/{i}")
	public String deleteStudent(@PathVariable int id) {
		studRepo.deleteById(id);
		return "Record Deleted Success !!";
	}
	
	@DeleteMapping("/name/{name}")
	public String deleteByName(@PathVariable String name) {
		studRepo.deleteByName(name);
		return "Record Deleted !!";
	}
}
