package com.revature.modelview.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.models.User;

public class FacePage implements Page{

	private static Logger log = LogManager.getLogger(Driver.class);

	
	public FacePage() {
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println(
				"###### FRONT PAGE ######\n" +
				"Welcome to Lane's Anime Plushie Shop\n\n"
				);
		setPageMenu();
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		Driver.ClearConsole();
		System.out.println(
				"Please select a choice from below:\n" +
				"1. Log In\n" +
				"2. Create a new account\n" +
				"3. Close application\n"
				);
		retrieveValidMenuChoice();
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
			sendToPage("LOGIN", null);
			break;
		case 2:
			sendToPage("CREATEACC", null);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	
	
	@Override
	public void sendToPage(String page, User u) {
		// TODO Auto-generated method stub
		Driver.mvc.navigate(page, u);
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

}
