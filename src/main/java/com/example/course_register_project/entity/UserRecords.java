package com.example.course_register_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserRecords {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String original_password;
	private String role;
	
	public UserRecords(String username, String password,String original_password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.original_password = original_password;
		this.role = role;
	}
	

	public UserRecords() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getOriginal_password() {
		return original_password;
	}

	public void setOriginal_password(String original_password) {
		this.original_password = original_password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
