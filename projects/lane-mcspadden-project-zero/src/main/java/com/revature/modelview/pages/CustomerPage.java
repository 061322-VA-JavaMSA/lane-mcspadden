package com.revature.modelview.pages;

import com.revature.Driver;
import com.revature.models.User;

public class CustomerPage implements Page {
	User loggedIn;
	
	public CustomerPage(User u) {
		loggedIn = u;
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome " + loggedIn.getUsername() + " to the store!");
		System.out.println("Please select an option to continue!");
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1. View Items in Shop" +
				"2. View Your Items" +
				"3. Logout"		
				);
		
	}

	@Override
	public void retrieveValidMenuChoice() {
		// TODO Auto-generated method stub
		String menuChoice = Driver.scan.nextLine();
		int c = Integer.parseInt(menuChoice);
		while(c != 1 && c != 2 && c != 3) {
			System.out.println("\nYou have entered an invalid menu choice\n");
			menuChoice = Driver.scan.nextLine();
			c = Integer.parseInt(menuChoice);
		}
		
		switch(c) {
		case 1:
			Driver.ClearConsole();
			viewOwnedItems(loggedIn);
			break;
		case 2:
			Driver.ClearConsole();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private void viewOwnedItems(User loggedIn2) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void sendToPage(String page, User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

}
