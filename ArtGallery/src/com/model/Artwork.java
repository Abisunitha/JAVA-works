package com.model;

public class Artwork {
	private int artworkId;
	 private String title;
	 private String year;
	 private String description;
	 private String imageUrl;
	 

	 private int artistId;
	private int categoryId;

	 public Artwork(int artworkId, String title, String year, String description, String imageUrl, int artistId,
			int categoryId) {
		super();
		this.artworkId = artworkId;
		this.title = title;
		this.year = year;
		this.description = description;
		this.imageUrl = imageUrl;
		this.artistId = artistId;
		this.categoryId = categoryId;
	}
	
	 
	 public Artwork() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getArtworkId() {
		return artworkId;
	}


	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getArtistId() {
		return artistId;
	}


	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	@Override
	public String toString() {
		return "Artwork [artworkId=" + artworkId + ", title=" + title + ", year=" + year + ", description="
				+ description + ", imageUrl=" + imageUrl + ", artistId=" + artistId + ", categoryId=" + categoryId
				+ "]";
	}
	 
	 
}
