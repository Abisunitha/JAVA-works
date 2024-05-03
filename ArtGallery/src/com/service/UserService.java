package com.service;
import java.sql.SQLException;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.InvalidCredentialsException;
import com.model.User;
public class UserService {
	UserDao userDao = new UserDaoImpl();

	public void save(User user) throws SQLException {
		userDao.save(user);
		
	}

	public User login(String username, String password) throws SQLException, InvalidCredentialsException {
		 
		User user = userDao.login(username,password);
		if(user == null) {
			throw new InvalidCredentialsException ("Invalid Credentials");
		}
		return user;
	}
}
