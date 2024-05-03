package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ArtistDao;
import com.dao.ArtworkDao;
import com.dao.ArtworkDaoImpl;
import com.model.Artwork;
import com.dao.ArtistDaoImpl;
import com.dao.CategoryDao;
import com.dao.CategoryDaoImpl;
import com.dto.ArtworkDto;
import com.exception.ResourceNotFoundException;

public class ArtworkService {

	ArtworkDao dao = new ArtworkDaoImpl();
	ArtistDao artistDao=new ArtistDaoImpl();
	CategoryDao categoryDao=new CategoryDaoImpl();
	public void save(Artwork artwork) throws SQLException,ResourceNotFoundException{
		// TODO Auto-generated method stub
		boolean isArtistIdValid = artistDao.findOne(artwork.getArtistId());
		if(!isArtistIdValid)
				throw new ResourceNotFoundException("Artist ID invalid");
		boolean isCatIdValid=categoryDao.findOne(artwork.getCategoryId());
		if(!isCatIdValid)
			throw new ResourceNotFoundException("Categor ID invalid");
		
		dao.save(artwork);
		
	}
	public List<Artwork> getArtworkByArtist(int artistId) throws SQLException,ResourceNotFoundException{
		boolean isArtistIdValid=artistDao.findOne(artistId);
		if(!isArtistIdValid)
			throw new ResourceNotFoundException("Artist ID invalid");
		// TODO Auto-generated method stub
		return dao.getArtworkByArtistId(artistId);
	}
	public List<ArtworkDto> getArtworkStats() throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.getArtworkStats();
	}
	

}
