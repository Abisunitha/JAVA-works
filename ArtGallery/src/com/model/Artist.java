package com.model;

public class Artist {
      private int artistID;
      private String name;
      private String biography;
      private String nationality;
      
	public Artist(int artistID, String name, String biography, String nationality) {
		super();
		this.artistID = artistID;
		this.name = name;
		this.biography = biography;
		this.nationality = nationality;
	}

	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}

	@Override
	public String toString() {
		return "Artist [artistID=" + artistID + ", name=" + name + ", biography=" + biography + ", nationality="
				+ nationality + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
      
}
