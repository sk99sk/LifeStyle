package com.fastenal.spring.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastenal.spring.model.User;

public class UserDAOImpl implements UserDAO {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User addes successfully, User Details=" + user);

	}

	@Override
	public User getUserById(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		
		if(Objects.isNull(email)) {
			logger.error("UserDAOImpl :: getUserById :: Email is null");
		}

			User user = (User) session.get(User.class, new String(email));
			logger.info("User loaded successfully, User details=" + user);
			return user;
	}

}
