package com.dto;

public class ArtworkDto {
      private String name;
      private int numberOfArtworks;
      
public ArtworkDto(String name, int numberOfArtworks) {
		super();
		this.name = name;
		this.numberOfArtworks = numberOfArtworks;
	}
	public ArtworkDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfArtworks() {
		return numberOfArtworks;
	}
	public void setNumberOfArtworks(int numberOfArtworks) {
		this.numberOfArtworks = numberOfArtworks;
	}
	@Override
	public String toString() {
		return "ArtworkDto [name=" + name + ", numberOfArtworks=" + numberOfArtworks + "]";
	}
      
}
