package com.revature.shop_ui;

import com.revature.driver.Shop;
import com.revature.users.User;
import com.revature.users.UserTitle;

public class AccountCreationPage {

	public AccountCreationPage() {
		User newUser = new User();
		System.out.println("Please enter a Username");
		newUser.setUsername(LoginScreen.scan.nextLine());
		System.out.println("Please enter a Password");
		newUser.setPassword(LoginScreen.scan.nextLine());
		newUser.setTitle(UserTitle.CLIENT);
		addAccount(newUser);
	}
	
	public void addAccount(User u) {
		Shop.db.addUser(u);
	}
}
