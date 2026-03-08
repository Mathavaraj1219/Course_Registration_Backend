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

import com.example.course_register_project.entity.Course;
import com.example.course_register_project.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/admin/course")
	public String addCourse(@RequestBody Course course) {
		courseService.addCourseService(course);
		return "Course Added Successfully!!!";
	}
	
	@GetMapping("/admin/course")
	public List<Course> getCourse() {
		return courseService.getAllCourseDetails();
	}
	
	@GetMapping("/student/course")
	public List<Course> getAvailableCourse() {
		return courseService.getAllCourseDetails();
	}
	
	@GetMapping("/admin/course/{courseId}")
	public Optional<Course> getSingleCourse(@PathVariable Long courseId){
		return courseService.getSingleCourseDetails(courseId);
	}
	
	@PutMapping("/admin/course/{courseId}")
	public String updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
		courseService.updateCourseDetails(courseId, course);
		return "Course Updated Successfully!!!";
	}
	
	@DeleteMapping("/admin/course/{courseId}")
	public String deleteCourse(@PathVariable Long courseId) {
		boolean delete = courseService.deleteCourseDetail(courseId);
		
		if(delete) {
			return "Course Deleted!!!";
		}else {
			return "Course is not Found!!!";
		}
	}

}
