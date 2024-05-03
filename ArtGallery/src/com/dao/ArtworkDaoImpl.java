package com.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.ArtworkDto;
import com.model.Artwork;

import com.utility.DBConnection;

public class ArtworkDaoImpl implements ArtworkDao {

	@Override
	public int save(Artwork artwork) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO artworks (ArtworkID, Title, ArtistID, CategoryID, Year,Description) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, artwork.getArtworkId());
		pstmt.setString(2, artwork.getTitle());
		pstmt.setInt(3,artwork.getArtistId());
		pstmt.setInt(4,artwork.getCategoryId());
		pstmt.setString(5,artwork.getYear());
		pstmt.setString(6,artwork.getDescription());
		
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public List<Artwork> getArtworkByArtistId(int artistId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select *from artworks a join artists at ON a.artistID=at.artistID"
				+ " where a.artistID=? and at.isActive='yes'";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, artistId);
		ResultSet rst =pstmt.executeQuery();
		List<Artwork> list = new ArrayList<>();
		while(rst.next()==true) {
			int id=rst.getInt("ArtworkID");
			String title=rst.getString("Title");
			String year=rst.getString("year");
			Artwork artwork=new Artwork(id,title,year,"","",artistId,0);
			list.add(artwork);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<ArtworkDto> getArtworkStats() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select a.name,count(a.artistID) as numberOfArtworks"
				+ " from artists a join artworks art on art.artistID=a.artistID"
				+ " group by a.name";
		PreparedStatement pstmt= con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<ArtworkDto> list=new ArrayList<>();
		while(rst.next()==true) {
			String name=rst.getString("name");
			int numberOfArtworks =rst.getInt("numberOfArtworks");
			ArtworkDto artwork=new ArtworkDto(name,numberOfArtworks);
			list.add(artwork);
		}
		DBConnection.dbClose();
		return list;
	}

}
