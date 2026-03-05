package com.example.course_register_project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_register_project.entity.UserRecords;
import com.example.course_register_project.repository.UserRepository;
import com.example.course_register_project.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserRepository userRepository;
	    
	@PostMapping("/register")
    public String register(@RequestBody UserRecords user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }
	
	@PostMapping("/login")
    public Map<String, String> login(@RequestBody UserRecords user) {

        UserRecords dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(user.getPassword(), dbUser.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                dbUser.getUsername(),
                dbUser.getRole()
        );
        
        return Map.of("token", token,
        		       "role", dbUser.getRole());
    }

}
