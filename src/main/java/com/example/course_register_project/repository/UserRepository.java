package com.example.course_register_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course_register_project.entity.UserRecords;

public interface UserRepository extends JpaRepository<UserRecords,Long>{

	Optional<UserRecords> findByUsername(String username);

}
