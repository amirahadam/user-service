package com.cognixia.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognixia.model.LoginDetails;
import com.cognixia.model.UserDetails;
import com.cognixia.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	UserService userService;
	
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int userid;
	
	// GET - retrieve all users
	@GetMapping
	public ResponseEntity<List<UserDetails>> getUserDetails()
	{
		return ResponseEntity.ok(userService.getUsers());
	}
	// POST - add user to database
	@PostMapping
	public ResponseEntity<UserDetails> addUserDetails(@RequestBody UserDetails user)
	{
		Date datetime = new Date();
		user.setLastLogin(format.format(datetime));
		UserDetails createdUserDetails = userService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUserDetails.getUserid()).toUri();
		return ResponseEntity.created(location).build();
	}
	// POST - user login
	@PostMapping("login")
	public int login(@Valid @RequestBody LoginDetails loginDetails)
	{

		List<UserDetails> users = userService.getUsers();
		for(UserDetails user: users) {
			if(user.getUsername().equals(loginDetails.getUsername()) && user.getPassword().equals(loginDetails.getPassword())) {
				// update last login time
				Date datetime = new Date();
				user.setLastLogin(format.format(datetime));
				userService.addUser(user);
				userid=user.getUserid();
				return userid;
			}
		}
		userid=0;
		return userid;
	}
	
}
