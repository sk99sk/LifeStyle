package com.fastenal.spring.service;

import org.springframework.transaction.annotation.Transactional;

import com.fastenal.spring.dao.UserDAO;

import com.fastenal.spring.model.User;

public class UserServiceImpl implements UserService {
	
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	@Transactional("transactionManagerUser")
	public void addUser(User user) {
		this.userDAO.addUser(user);

	}

	@Override
    @Transactional("transactionManagerUser")
	public User getUserById(String email) {
		return this.userDAO.getUserById(email);
	}

}
