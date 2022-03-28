package com.fastenal.spring.dao;

import com.fastenal.spring.model.User;

public interface UserDAO {

	public void addUser(User user);
	public User getUserById(String email);
	
}
