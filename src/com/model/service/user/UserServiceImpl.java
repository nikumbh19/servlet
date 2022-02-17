package com.model.service.user;

import java.util.Optional;

import com.model.persistence.user.User;
import com.model.persistence.user.UserDao;
import com.model.persistence.user.UserDaoImpl;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);		
	}

	@Override
	public Optional<User> getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

}
