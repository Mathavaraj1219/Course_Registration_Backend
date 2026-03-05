package com.example.course_register_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_register_project.entity.CourseRegister;
import com.example.course_register_project.entity.UserRecords;
import com.example.course_register_project.service.RegisterService;

@RestController
@RequestMapping("/api")
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("/admin/courseregister")
	public String courseRegister(@RequestBody CourseRegister courseRegister) {
		registerService.addStudentCourseRegister(courseRegister);
		return "Congratulation! Enrollment Successfull";
	}
	
	@PostMapping("/student/courseregister")
	public String studentCourseRegister(@RequestBody CourseRegister courseRegister) {
		registerService.addStudentCourseRegister(courseRegister);
		return "Congratulation! Enrollment Successfull";
	}
	
	@GetMapping("/admin/courseregister")
	public List<CourseRegister> getCourseRegister(){
		return registerService.getRegisterStudent();
	}
	
	@GetMapping("/student/courseregister")
	public List<CourseRegister> getStudentCourseRegister(){
		return registerService.getRegisterStudent();
	}
	
	@GetMapping("/admin/courseregister/{Id}")
    public Optional<CourseRegister> getSingleStudent(@PathVariable Long Id){
		return registerService.getStudentDetail(Id);
	}
	
	@PutMapping("/admin/courseregister/{Id}")
	public String updateStudentDetails(@PathVariable Long Id, @RequestBody CourseRegister courseRegister) {
		registerService.updateRegisterStudent(Id, courseRegister);
		return "Student Details Updated Successfully!!!";
	}
	
	@DeleteMapping("/admin/courseregister/{Id}")
	public String deleteStudentDetail(@PathVariable Long Id) {
		Boolean delete = registerService.delateRegisterStudent(Id);
		
		if(delete) {
			return "Register Student Deleted Successfully!!!";
		}else {
			return "Register Student is not Found!!!";
		}
	}
	
	@GetMapping("/admin/user")
	public List<UserRecords> userDetails() {
		return registerService.getUserDetails();
	}

}
