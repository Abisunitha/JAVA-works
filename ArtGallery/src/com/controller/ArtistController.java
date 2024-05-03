package com.controller;
import java.sql.SQLException;
import com.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.model.Artist;
import com.service.ArtistService;

public class ArtistController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
		ArtistService artistService=new ArtistService();
		
		while(true) {
			System.out.println("----------Artist Ops-------------");
			System.out.println("Press 1. Insert Artist ");
			System.out.println("Press 2. Delete Artist");
			System.out.println("press 3. Soft delete Artist");
			System.out.println("press 4: Display all");
			System.out.println("press 0: Exit");
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting Artist Module..");
				break;
			}
			switch(input) {
			case 1: 
				Random random =new Random();
				int randomNumber = random.nextInt();
				int id=randomNumber<0?randomNumber*-1:randomNumber;
				System.out.println("Enter Name");
				sc.nextLine();
				String name=sc.nextLine();
				System.out.println("Enter Biography");
				String biography=sc.nextLine();
			    System.out.println("Enter Nationality");
			    String nationality=sc.nextLine();
			    
			    Artist artist=new Artist(id,name,biography,nationality);
			    try {
			    int status=artistService.insert(artist);
			    if(status==1)
			    	System.out.println("Artist record added to DB");
			    else
			    	System.out.println("Insert operation failed");
			    }catch(SQLException e){
			    	System.out.println(e.getMessage());
			    
			    }
			    //System.out.println(name + " " +biography + " " +);
				break; 
			case 2:
				System.out.println("Enter ArtistID");
				try {
				artistService.deleteByid(sc.nextInt());
				System.out.println("Artist record deleted");
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println("Enter ArtistsID");
				
				try {
					artistService.softDeleteByid(sc.nextInt());
					System.out.println("Artist record de-activated");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
				List<Artist> list=artistService.findAll();
				for(Artist a :list) {
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

	public static void artistMenu() {
		// TODO Auto-generated method stub
		String[] sarry = {""};
		main(sarry);
	}
}
