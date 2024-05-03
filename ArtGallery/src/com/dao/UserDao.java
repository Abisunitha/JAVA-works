package com.dao;

import java.sql.SQLException;

import com.exception.InvalidCredentialsException;
import com.model.User;

public interface UserDao {
	int save(User user)  throws SQLException;

	User login(String username, String password) throws SQLException, InvalidCredentialsException;
}
