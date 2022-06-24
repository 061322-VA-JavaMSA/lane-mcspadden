package com.revature.modelview.pages;

import com.revature.models.User;

public interface Page {
	public void setUpPage();
	public void setPageMenu();
	public void retrieveValidMenuChoice();
	public void sendToPage(String page, User u);
	public void logOut();
}
