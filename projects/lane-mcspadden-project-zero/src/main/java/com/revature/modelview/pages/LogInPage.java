package com.revature.modelview.pages;

import javax.security.auth.login.LoginException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.models.User;
import com.revature.models.UserRank;

public class LogInPage implements Page{

	private static Logger log = LogManager.getLogger(Driver.class);
	User login = new User();
	UserDAO ud = new UserPostgres();
	
	public LogInPage() {
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		System.out.println("Please enter your login information at the prompts below");
		setPageMenu();
	}

	@Override
	public void setPageMenu() {
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
			log.info("User Login: " + login);
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
			log.error(e);
			e.printStackTrace();
		}
		}
	}

	@Override
	public void retrieveValidMenuChoice() {
		
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
