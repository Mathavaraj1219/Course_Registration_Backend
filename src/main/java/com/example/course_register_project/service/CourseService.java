package com.example.course_register_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_register_project.entity.Course;
import com.example.course_register_project.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public void addCourseService(Course course) {
		courseRepository.save(course);
	}
	
	public List<Course> getAllCourseDetails() {
		return courseRepository.findAll();
	}
	
	public Optional<Course> getSingleCourseDetails(Long courseId){
		return courseRepository.findById(courseId);
	}
	
	public void updateCourseDetails(Long courseId, Course course) {
		Course getCourse = courseRepository.findById(courseId).orElseThrow();
		if(getCourse != null) {
			getCourse.setCourseId(course.getCourseId());
			getCourse.setCourseName(course.getCourseName());
			getCourse.setTrainer(course.getTrainer());
			getCourse.setDuration(course.getDuration());
			getCourse.setCoursefee(course.getCoursefee());
			courseRepository.save(getCourse);
		}
	}
	
	public boolean deleteCourseDetail(Long courseId) {
		if(courseRepository.existsById(courseId)) {
			courseRepository.deleteById(courseId);
			return true;
		}
		else {
			return false;
		}
	}

}
