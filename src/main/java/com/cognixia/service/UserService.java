package com.cognixia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.model.UserDetails;
import com.cognixia.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserDetails> getUsers() {
		return userRepository.findAll();
	}
	public UserDetails addUser(UserDetails user) {
		return userRepository.save(user);
	}
}
