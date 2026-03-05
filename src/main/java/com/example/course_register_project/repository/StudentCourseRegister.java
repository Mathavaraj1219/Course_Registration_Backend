package com.example.course_register_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course_register_project.entity.CourseRegister;

public interface StudentCourseRegister extends JpaRepository<CourseRegister, Long>{

}
