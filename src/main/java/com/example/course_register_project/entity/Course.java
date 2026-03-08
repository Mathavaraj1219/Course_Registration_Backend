package com.example.course_register_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
	private Long courseId;
	private String courseName;
	private String trainer;
	private int duration;
	private int coursefee;
	
	public Course(Long courseId, String courseName, String trainer, int duration, int coursefee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.trainer = trainer;
		this.duration = duration;
		this.coursefee = coursefee;
	}

	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCoursefee() {
		return coursefee;
	}

	public void setCoursefee(int coursefee) {
		this.coursefee = coursefee;
	}
	

}
