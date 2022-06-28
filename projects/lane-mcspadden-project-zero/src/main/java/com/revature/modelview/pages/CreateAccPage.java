package com.revature.modelview.pages;

import com.revature.Driver;
import com.revature.models.User;

public class CreateAccPage implements Page {

	private User tempUser;
	
	public CreateAccPage() {
		tempUser = new User();
		setUpPage();
	}

	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println(
				"Please create a new account below!\n"
				);
		
		setPageMenu();
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
			String username, password;
			System.out.println("Please enter a username");
			username = Driver.scan.nextLine();
			System.out.println("Please enter a password");
			password = Driver.scan.nextLine();
			
			tempUser.setUsername(username);
			tempUser.setPassword(password);
			
			tempUser = Driver.us.createUser(tempUser);
			retrieveValidMenuChoice();
	}

	@Override
	public void retrieveValidMenuChoice() {
		// TODO Auto-generated method stub
			Driver.ClearConsole();
			sendToPage("LOGIN", null);
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
