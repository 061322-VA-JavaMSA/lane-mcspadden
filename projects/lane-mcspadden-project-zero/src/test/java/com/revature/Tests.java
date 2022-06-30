package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.revature.models.AnimePlush;
import com.revature.models.AnimePlushStatus;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.PlushService;
import com.revature.services.UserService;

class Tests {

	@Test
	void authTest() {
		AuthService as = new AuthService();
		User testUser = new User();
		User expected = null;
		testUser.setUsername("LaneM123");
		testUser.setPassword("Pass1");
		testUser.setId(1);
		
		try {
			expected = as.login(testUser.getUsername(), testUser.getPassword());
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(testUser, expected);
		
	}
	
	@Test
	void userTest() {
		UserService us = new UserService();
		User testUser = new User();
		User expected = null;
		testUser.setUsername("TestR123");
		testUser.setPassword("Pass1");
		testUser.setId(999);
		
		expected = us.createUser(testUser);
		
		assertEquals(testUser, expected);
	}
	
	@Test
	void plushTest() {
		PlushService ps = new PlushService();
		AnimePlush testPlush = new AnimePlush();
		List<AnimePlush> expected = new ArrayList<>();
		List<AnimePlush> actual = new ArrayList<>();
		testPlush.setId(3);
		testPlush.setName("Nezuko");
		testPlush.setDescription("Demon Slayer");
		testPlush.setPrice(300);
		actual.add(testPlush);
		expected = ps.getPlushesByUserId(1);
		
		
		assertEquals(expected, actual);
	}
}
