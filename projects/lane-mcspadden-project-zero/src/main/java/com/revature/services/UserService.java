package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class UserService {
	private UserDAO ud = new UserPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);
	
	public List<User> getUsers(){
		return ud.retrieveUsers();
	}
	
	public User createUser(User u) {
		// logic to validate u
		User user;
		if(checkIfUsernameUsed(u)) {
			user = ud.createUser(u);
			log.info("User: " + user + " was created.");
			return user;
		} else {
			System.out.println(u.getUsername() + " has already been registered\nPress enter to continue");
			String dummy = Driver.scan.nextLine();
			Driver.mvc.navigate("HOME", null);
			return null;
		}
	}
	
	private boolean checkIfUsernameUsed(User u) {
		
		User un = new User();
		un = ud.retrieveUserByUsername(u.getUsername());
		
		if(un == null) {
			return true;
		} else {
			return false;
		}
		
	}
}
