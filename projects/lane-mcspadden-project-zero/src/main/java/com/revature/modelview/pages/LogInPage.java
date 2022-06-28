package com.revature.modelview.pages;

import javax.security.auth.login.LoginException;

import com.revature.Driver;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.models.User;
import com.revature.models.UserRank;

public class LogInPage implements Page{

	User login = new User();
	UserDAO ud = new UserPostgres();
	public LogInPage() {
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println("Please enter your login information at the prompts below");
		setPageMenu();
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		String username, password;
		System.out.println("Please enter your username: ");
		username = Driver.scan.nextLine();
		System.out.println("Please enter your password: ");
		password = Driver.scan.nextLine();
		
		if(login.getUsername() == null) {
		try {
			login = Driver.as.login(username, password);
			login.setId(ud.retrieveUserByUsername(username).getId());
			login.setRank(ud.retrieveUserByUsername(username).getRank());
			switch(login.getRank()) {
			case CLIENT:
				sendToPage("CUSTOMER", login);
				break;
			case EMPLOYEE:
				sendToPage("EMPLOYEE", login);
			case MANAGER:
				break;
			default:
				break;

			}
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	@Override
	public void retrieveValidMenuChoice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendToPage(String page, User u) {
		// TODO Auto-generated method stub
		Driver.ClearConsole();
		Driver.mvc.navigate(page, u);
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

}
