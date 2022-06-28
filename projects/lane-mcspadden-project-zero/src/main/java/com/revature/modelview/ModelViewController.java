package com.revature.modelview;

import com.revature.models.User;
import com.revature.modelview.pages.CreateAccPage;
import com.revature.modelview.pages.CustomerPage;
import com.revature.modelview.pages.FacePage;
import com.revature.modelview.pages.LogInPage;

public class ModelViewController {
	
	public void navigate(String page, User u) {
		// TODO Auto-generated method stub
		Object currentPage;
		switch(page) {
		case "LOGIN":
			currentPage = new LogInPage();
			break;
		case "CREATEACC":
			currentPage = new CreateAccPage();
			break;
		case "CUSTOMER":
			currentPage = new CustomerPage(u);
		
		
		}
	}
	
	
	
	
	
	
	
}
