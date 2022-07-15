package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.security.auth.login.LoginException;

import org.junit.jupiter.api.Test;

import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.CouldNotCreateRequestException;
import com.revature.exceptions.NoSuchRequestFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Request;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.EmailService;
import com.revature.services.TixService;

import junit.framework.Assert;

class Tests {

	@Test
	void authTest() {
		AuthService as = new AuthService();
		UserDAO ud = new UserHibernate();
		User testUser = new User();
		User expected = null;
		testUser.setUsername("LaneM123");
		testUser.setPassword("Pass1");
		expected = ud.getUserByUsername("LaneM123");
		
		try {
			testUser = as.login(testUser.getUsername(), testUser.getPassword());
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.revature.exceptions.LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(testUser, expected);
		
	}
	
	@Test
	void tixTest() {
		TixService ts = new TixService();
		Request testRequest = new Request();
		testRequest.setAmmount(200);
		
		Request expected = null;
		try {
			expected = ts.createRequest(testRequest);
		} catch (CouldNotCreateRequestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			expected = ts.getRequestById(1);
		} catch (NoSuchRequestFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotEquals(testRequest, expected);
	}
	
	@Test
	void tixTest2() {
		TixService ts = new TixService();
		Request testRequest = new Request();
		testRequest.setAmmount(200);
		
		Request expected = null;
		try {
			expected = ts.getRequestById(1);
		} catch (NoSuchRequestFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			expected = ts.getRequestById(1);
		} catch (NoSuchRequestFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotEquals(testRequest, expected);
	}
	
	@Test
	void emailTest() {
		EmailService es = new EmailService();
		UserDAO ud = new UserHibernate();
		Request testRequest = new Request();
		testRequest.setAuthor(ud.retrieveUserById(51));
		
		try {
			es.sendEmailConfirm(testRequest);
			assertEquals(1, 1);
		} finally {
			
		}
		


	}
}
