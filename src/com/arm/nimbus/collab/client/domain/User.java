package com.arm.nimbus.collab.client.domain;

import com.arm.nimbus.collab.shared.IUser;

public class User implements IUser {

	public User(String name) {
		this.username = name;
	}
	
	String username;
	String email;
	String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
