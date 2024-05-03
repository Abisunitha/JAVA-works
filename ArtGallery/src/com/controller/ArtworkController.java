package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.ArtworkDto;
import com.exception.ResourceNotFoundException;
import com.model.Artist;
import com.model.Artwork;
import com.model.Category;
import com.service.ArtistService;
import com.service.ArtworkService;
import com.service.CategoryService;

public class ArtworkController {
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	ArtworkService artworkService=new ArtworkService();
	ArtistService artistService=new ArtistService();
	CategoryService categoryService=new CategoryService();
	while(true) {
		
		System.out.println("Press 1. Insert Artwork ");
		System.out.println("press 2: Display Artwork by Artist");
		System.out.println("press 3: Display Artwork stats");
		System.out.println("press 0: Exit");
		int input=sc.nextInt();
		if(input==0) {
			System.out.println("Exiting Artist Module..");
			break;
		}
		switch(input) {
		case 1: 
			try {
			Artwork artwork=new Artwork();	
			
			Random random =new Random();
			int randomNumber = random.nextInt();
			int id=randomNumber<0?randomNumber*-1:randomNumber;
			artwork.setArtworkId(id);
			System.out.println("Enter title");
			sc.nextLine();
			artwork.setTitle(sc.nextLine());
			
			System.out.println("Enter year");
			artwork.setYear(sc.nextLine());
			
		    System.out.println("Enter description");
		    artwork.setDescription(sc.nextLine()); 
		    
		    List<Artist> list=artistService.findAll();
			for(Artist a :list) {
				System.out.println(a);
				
			}
			System.out.println("Enter Artist ID");
			artwork.setArtistId(sc.nextInt());
			
			List<Category> listCat=categoryService.findAll();
			for(Category c :listCat) {
				System.out.println(c);
			}
			System.out.println("Enter Category ID");
			artwork.setCategoryId(sc.nextInt());
			
			artworkService.save(artwork);
			System.out.println("Artwork added to DB");
            }catch(SQLException e) {
            	System.out.println(e.getMessage());
            }catch(ResourceNotFoundException e) {
            	System.out.println(e.getMessage());
            }
			break;
		case 2:
			try {
				List<Artist> list=artistService.findAll();
				for(Artist a:list) {
					System.out.println(a);
				}
				System.out.println("Enter Artist ID");
				int artistId=sc.nextInt();
			
				List<Artwork> listArtwork = artworkService.getArtworkByArtist(artistId);
			    for(Artwork a : listArtwork) {
			    	System.out.println(a);
			    }
			}catch(ResourceNotFoundException e) {
			       System.out.println(e.getMessage());
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			try {
				List<ArtworkDto> list=artworkService.getArtworkStats();
				for(ArtworkDto a : list) {
					System.out.println(a);
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			break;
            }
}
	sc.close();
 }
}
