package com.cognixia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue
	private int userid;
	private String username;
	private String password;
	private String email;
	private String lastLogin;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastlogin) {
		this.lastLogin = lastlogin;
	}
	
}
