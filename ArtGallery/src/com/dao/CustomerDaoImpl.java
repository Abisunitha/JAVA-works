package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Customer;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public int save(Customer customer) throws SQLException {
		// insert artist record in DB
		Connection con = DBConnection.dbConnect();
		String sql="INSERT INTO customer (id, name,user_id) VALUES (?,?,?)";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt(1, customer.getId());
		pstmt.setString(2, customer.getName());
		pstmt.setInt(3, customer.getUserId());
		//execute the query 
		int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
		DBConnection.dbClose();
		return status;		 
		
	}

}
