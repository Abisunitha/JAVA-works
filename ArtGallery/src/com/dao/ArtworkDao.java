package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ArtworkDto;
import com.model.Artwork;

public interface ArtworkDao {
     
	int save(Artwork artwork) throws SQLException;
    List<Artwork> getArtworkByArtistId(int artistId) throws SQLException;
    List<ArtworkDto> getArtworkStats()throws SQLException;
}
