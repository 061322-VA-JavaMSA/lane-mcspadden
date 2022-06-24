package com.revature.modelview.pages;

import com.revature.models.User;

public class FacePage implements Page{

	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println(
				"###### LOGIN PAGE ######\n" +
				"Welcome to Lane's Anime Plushie Shop\n\n"
				);
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"Please select a choice from below:\n" +
				"1. Log In\n" +
				"2. Create a new account\n" +
				"3. Close application\n"
				);
	}

	@Override
	public void retrieveValidMenuChoice() {
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
