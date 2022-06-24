package com.revature;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.models.AnimePlush;
import com.revature.models.User;
import com.revature.modelview.ModelViewController;
import com.revature.services.AuthService;
import com.revature.services.PlushService;
import com.revature.services.UserService;

public class Driver {

	static Scanner scan;
	static AuthService as;
	static UserService us;
	static PlushService ps;
	static ModelViewController mvc;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String args[]) {
		initServices();
	}
	
	
	public static void initServices() {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		ps = new PlushService();
		mvc = new ModelViewController();
	}
	
	
	
	
}
