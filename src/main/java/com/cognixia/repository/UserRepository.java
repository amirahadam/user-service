package com.cognixia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	
}
