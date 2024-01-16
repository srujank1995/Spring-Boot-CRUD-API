package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Student Name")
	private String name;
	
	@Column(name = "Student City")
	private String city;
	
	@Column(name = "Student Age")
	private int age;
	
	@Column(name = "Student Roll No")
	private int roll_no;

	@Column(name = "Student Class")
	private String sClass;
	
	@Column(name = "Student Section")
	private String section;
	
}
