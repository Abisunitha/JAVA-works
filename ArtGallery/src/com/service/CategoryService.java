package com.service;
import com.dao.CategoryDao;
import java.sql.SQLException;
import java.util.List;
import com.dao.CategoryDaoImpl;
import com.model.Category;

public class CategoryService {
    CategoryDao dao = new CategoryDaoImpl();


	public List<Category> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
    
   
}
