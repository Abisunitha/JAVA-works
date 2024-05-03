package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Category;
import com.utility.DBConnection;



public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select*from categories";
		PreparedStatement pstmt= con.prepareStatement(sql);
		ResultSet rst =pstmt.executeQuery();
		List<Category>list=new ArrayList<>();
		while(rst.next()==true) {
			int id=rst.getInt("categoryID");
			String name=rst.getString("name");
			Category category=new Category(id,name);
			list.add(category);
		}
		
		
		DBConnection.dbClose();
		
		return list;
	}

	@Override
	public boolean findOne(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select categoryID from categories where categoryID=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, categoryId);
		ResultSet rst =pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
	}
	

}
