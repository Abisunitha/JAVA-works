package com.dao;
import java.sql.SQLException;
import java.util.List;
import com.exception.ResourceNotFoundException;
import com.model.Artist;
public interface ArtistDao {
        int save(Artist artist)throws SQLException;
        void deleteById(int id) throws SQLException,ResourceNotFoundException;
        void softDeleteById(int id) throws SQLException,ResourceNotFoundException; 
        int update(int id,Artist updateArtist) throws SQLException,ResourceNotFoundException;
        List<Artist> findAll()throws SQLException;
        Boolean findOne(int id) throws SQLException;
        
        
}
