package com.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.userapp.model.JwtUserRequest;
import com.userapp.service.JwtUserServiceImpl;
import com.userapp.util.JwtTokenUtil;

@RestController
@RequestMapping("/users-service/v1")
public class JwtUserController {
	private final JwtUserServiceImpl userServiceImpl;

	private final PasswordEncoder passwordEncoder;

	private final JwtTokenUtil jwtTokenUtil;
	
	public JwtUserController(JwtUserServiceImpl userServiceImpl, PasswordEncoder passwordEncoder,
			JwtTokenUtil jwtTokenUtil) {
		super();
		this.userServiceImpl = userServiceImpl;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	
	
	//http://localhost:8085/users-service/v1/register
	//first time user
	@PostMapping("/register")
	public ResponseEntity<Void> createUser(@RequestBody JwtUserRequest userRequest) {
		//Get pwd from userRequest
		String password=userRequest.getPassword();
		//encode the password using password Encoder
		String newpassword=passwordEncoder.encode(password);
		//attaching newpassword to userRequest
		userRequest.setPassword(newpassword);
		
		//call the service layer method to save the apiuser object
		userServiceImpl.createUser(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//http://localhost:8085/users-service/v1/login
	//user logging in and getting the token
	@PostMapping("/login")
	public ResponseEntity<String> authenticate(@RequestBody JwtUserRequest userRequest){
		// get the username
		System.out.println("Inside controller");
		String username = userRequest.getUsername();
		System.out.println(username);
		// check if the name is available in the db
		UserDetails userdetails =  userServiceImpl.loadUserByUsername(username);
		String token = jwtTokenUtil.generateToken(userdetails);
		return ResponseEntity.ok(token);
	}

	// http://localhost:8085/users-service/v1/users/userId/1
    @GetMapping("users/userId/{userId}")
    public ResponseEntity<JwtUserRequest> getUserById(@PathVariable int userId) {
    	JwtUserRequest jwtUser=userServiceImpl.getUserbyId(userId);
        return ResponseEntity.ok(jwtUser);
        		
               
    }
	
}
