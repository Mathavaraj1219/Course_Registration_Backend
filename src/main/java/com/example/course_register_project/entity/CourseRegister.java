package com.example.course_register_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseRegister {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String emailId;
	private String courseName;
	private boolean feepayment;
	
	public CourseRegister(String name, String emailId, String courseName, boolean feepayment) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.courseName = courseName;
		this.feepayment = feepayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean isFeepayment() {
		return feepayment;
	}

	public void setFeepayment(boolean feepayment) {
		this.feepayment = feepayment;
	}

}
