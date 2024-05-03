package com.service;
import com.dao.*;
import com.exception.ResourceNotFoundException;

import java.sql.SQLException;
import java.util.List;

import com.model.Artist;

public class ArtistService {

	ArtistDao dao = new ArtistDaoImpl();
	public  int insert(Artist artist) throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.save(artist);
	}
	public void deleteByid(int id) throws SQLException, ResourceNotFoundException {
		boolean isIDValid = dao.findOne(id);
		if(!isIDValid)
			throw new ResourceNotFoundException("ID given is Invalid..");
		dao.deleteById(id);
		
		
		// TODO Auto-generated method stub
		
	}
	public void softDeleteByid(int id) throws ResourceNotFoundException,SQLException {
		// TODO Auto-generated method stub
		boolean isIdValid= dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given id invalid!!");
		dao.softDeleteById(id);
	}
	public List<Artist> findAll()throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
}
