package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Category;

public interface CategoryDao {

	List<Category> findAll()throws SQLException;
	boolean findOne(int categoryId)throws SQLException,ResourceNotFoundException;
}
