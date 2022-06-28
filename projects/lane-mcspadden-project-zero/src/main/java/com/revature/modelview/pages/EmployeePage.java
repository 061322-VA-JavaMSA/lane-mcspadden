package com.revature.modelview.pages;

import com.revature.Driver;
import com.revature.models.User;

public class EmployeePage implements Page {

	User employee = null;
	
	public EmployeePage(User u) {
		employee = u;
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to work " + employee.getUsername());
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1. View Offers\n" +
				"2. Add Items to Shop\n" +
				"3. Log out"		
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
			viewOffers();
			break;
		case 2:
			Driver.ClearConsole();
			break;
		case 3:
			sentToPage("LOGIN", null);
			break;
		default:
			break;
		}
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
