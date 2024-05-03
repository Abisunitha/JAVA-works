package com.controller;

	import java.sql.SQLException;
	import java.util.Random;
	import java.util.Scanner;

	import com.exception.InvalidCredentialsException;
import com.exception.ResourceNotFoundException;
import com.model.Customer;
	import com.model.User;
	import com.service.CustomerService;
	import com.service.UserService;

	public class AuthController {

		public static void main(String[] args) throws ResourceNotFoundException {
			Scanner sc = new Scanner(System.in);
			UserService userService = new UserService();
			CustomerService customerService =new CustomerService(); 
			while(true) {
				System.out.println("Press 1. Customer Sign-Up");
				System.out.println("Press 2. Login");
				System.out.println("Press 0. Exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting Artist Module..");
					break; 
				}
				
				switch(input) {
				case 1: 
					Customer customer = new Customer(); 
					User user = new User(); 
					/* Generating IDs of customer and User */
					
					Random random = new Random(); 
					int randomNumber = random.nextInt(); 
					int customerId =randomNumber<0?randomNumber*-1:randomNumber; 
					
					randomNumber = random.nextInt(); 
					int userId =randomNumber<0?randomNumber*-1:randomNumber;
					
					/* Attach Ids to their objects */
					customer.setId(customerId);
					user.setId(userId);
					
					/* Read details of customer and attach it to customer and user Obj */
					System.out.println("Enter customer name");
					sc.nextLine();
					customer.setName(sc.nextLine());
					System.out.println("Enter username");
					user.setUsername(sc.nextLine());
					System.out.println("Enter password");
					user.setPassword(sc.nextLine());
					
					/* Assign ROLE */
					user.setRole("CUSTOMER");
					
					/* Attach userId to customer obj */
					customer.setUserId(userId);
					
					/* Insert User obj in DB */
					try {
						userService.save(user);
						/* Insert customer obj in DB */
						customerService.save(customer);
						System.out.println("Customer SignUp Success..Please login");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 2:
					try {
						
						System.out.println("Enter username");
						sc.nextLine();
						String username = sc.nextLine();
						System.out.println("Enter password");
						String password = sc.nextLine();
						/* go to DB and check if this credentials are valid, if yes then return object*/
						 
						User userObj = userService.login(username,password);
							if(userObj.getRole().equalsIgnoreCase("CUSTOMER")) {
								//load customer menu
								System.out.println("Customer Menu");
							}
							else {
								System.out.println("--------Artist Menu--------");
								System.out.println("Welcome " + username);
								ArtistController.artistMenu();
							}
					} catch (SQLException e) {
						 System.out.println(e.getMessage());
					} catch (InvalidCredentialsException e) {
						 System.out.println(e.getMessage());
					}
					break; 
				 default: 
					 System.out.println("Invalid input given, try again!!!");
					
			}
			}
			sc.close();
		}
	}

