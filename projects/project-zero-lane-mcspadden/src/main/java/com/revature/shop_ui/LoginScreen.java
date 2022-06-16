package com.revature.shop_ui;

import java.util.Scanner;

import com.revature.database.TempDatabase;
import com.revature.users.User;
import com.revature.users.UserTitle;

public class LoginScreen {
	// Test account
	String tempUsername = "testAccount";
	String tempPassword = "testPassword";
	TempDatabase db;
	static Scanner scan;
	
	int userChoice;
	
	
	public LoginScreen(TempDatabase db) {
		scan = new Scanner(System.in);
		this.db = db;
		openingScreen();
		
	}
	
	public void openingScreen() 
	{
		System.out.println(
				"Welcome to the Shop!\n\n" +
				"Please select an option from below:\n" +
				"===================================\n" +
				"1. Log In\n" + 
				"2. Create an account\n" +
				"3. Exit application\n");
		
		userChoice = Integer.parseInt(scan.nextLine());
		
		viewController(userChoice);
	}
	
	public void viewController(int choice) {
		switch(choice) {
		case 1:
			loginView();
			break;
		case 2:
			accountCreationView();
			break;
		case 3:
			closeApplication();
			break;
		default:
			System.out.println("You have entered an invalid option, please try again");
			break;
		}
	}
	
	private void closeApplication() {
		// TODO Auto-generated method stub
		
	}

	private void accountCreationView() {
		// TODO Auto-generated method stub
		AccountCreationPage pg = new AccountCreationPage();
	}

	private void loginView() {
		String inputUser;
		String inputPass;
		
		System.out.println(
				  "Please enter your Username: ");
		inputUser = scan.nextLine();
		
		System.out.println(
				  "Please enter your password: ");
		inputPass = scan.nextLine();
		
		switch(testCredentials(inputUser, inputPass)) {
		case 1:
			CustomerAccountPage cus = new CustomerAccountPage();
			break;
		case 2:
			break;
		case 3:
			break;
		case -1:
			System.out.println("You have entered invalid credentials");
		default:
			break;
		}
	}

	public int testCredentials(String username, String password) {
			User loginAttempt = db.searchUser(username);
			
			if(loginAttempt.getPassword().equals(password)) {
				switch(loginAttempt.getTitle()) {
				case CLIENT:
					System.out.println("You are a client");
					return 1;
				case EMPLOYEE:
					System.out.println("You are a employee");
					return 2;
				case MANAGER:
					System.out.println("You are a manager");
					return 3;
				default:
					return -1;
					
				}
			}
			return -1;
	}
}
