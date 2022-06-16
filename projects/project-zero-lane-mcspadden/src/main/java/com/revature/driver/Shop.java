package com.revature.driver;

import com.revature.database.TempDatabase;
import com.revature.shop_ui.LoginScreen;

public class Shop {
	public static TempDatabase db = new TempDatabase();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			 LoginScreen login = new LoginScreen(db);
		}
	}

}
