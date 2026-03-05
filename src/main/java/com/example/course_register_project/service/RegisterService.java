package com.example.course_register_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_register_project.entity.CourseRegister;
import com.example.course_register_project.entity.UserRecords;
import com.example.course_register_project.repository.StudentCourseRegister;
import com.example.course_register_project.repository.UserRecordsRepository;

@Service
public class RegisterService {
	
	@Autowired
	StudentCourseRegister studentCourseRegister;
	@Autowired
	UserRecordsRepository userRecordsRepository;
	
	public void addStudentCourseRegister(CourseRegister courseRegister) {
		studentCourseRegister.save(courseRegister);
	}
	
	public List<CourseRegister> getRegisterStudent(){
		return studentCourseRegister.findAll();
	}
	
	public Optional<CourseRegister> getStudentDetail(Long Id){
		return studentCourseRegister.findById(Id);
	}
	
	public void updateRegisterStudent(Long Id, CourseRegister courseRegister) {
		CourseRegister CR = studentCourseRegister.findById(Id).orElseThrow();
		
		if(CR != null) {
			CR.setName(courseRegister.getName());
			CR.setEmailId(courseRegister.getEmailId());
			CR.setCourseName(courseRegister.getCourseName());
			CR.setFeepayment(courseRegister.isFeepayment());
			studentCourseRegister.save(CR);
		}
	}
	
	public boolean delateRegisterStudent(Long Id) {
		if(studentCourseRegister.existsById(Id)) {
			studentCourseRegister.deleteById(Id);
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<UserRecords> getUserDetails() {
		return userRecordsRepository.findAll();
	}

}
