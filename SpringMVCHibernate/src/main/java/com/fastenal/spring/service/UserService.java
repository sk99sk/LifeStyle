package com.fastenal.spring.service;

import com.fastenal.spring.model.User;

public interface UserService {

	
	public void addUser(User user);
	public User getUserById(String email);
	
}
