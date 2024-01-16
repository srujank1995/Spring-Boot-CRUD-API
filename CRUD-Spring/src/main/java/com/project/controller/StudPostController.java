package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.repository.StudRepository;

@RestController
@RequestMapping("/api")
public class StudPostController {
	
	
	@Autowired
	private StudRepository studRepo;
	
//********************** POST method ***********************//
	@PostMapping("/post")
	public String postByAttribute(
			@RequestAttribute ("Name")     String name,
			@RequestAttribute ("city")     String city,
			@RequestAttribute ("Age") 	   int age,
			@RequestAttribute ("roll_no")  int rollno,
			@RequestAttribute ("sClass")   String sClass,
			@RequestAttribute ("section")  String section) {
		Student studObj = new Student();
		studObj.setName(name);
		studObj.setCity(city);
		studObj.setAge(age);
		studObj.setRoll_no(rollno);
		studObj.setSClass(sClass);
		studObj.setSection(section);
		
		studRepo.save(studObj);
		
		return "Data Saved Successfully !!";
		
	}
	
//********************** POST Method JSON***********************//
	@PostMapping("/post/json")
	public String postAllValues (@RequestBody Student student ) {
		studRepo.save(student);
		return "Single Json Saved Success !!";
	}

//********************** POST Method JSON(Multiple)***********************//	
	
	@PostMapping("/post/json/all")
	public String postAllJson (@RequestBody List<Student> allStudent) {
		studRepo.saveAll(allStudent);
		return "All JSON Data Saved !!";
	}
	
}
