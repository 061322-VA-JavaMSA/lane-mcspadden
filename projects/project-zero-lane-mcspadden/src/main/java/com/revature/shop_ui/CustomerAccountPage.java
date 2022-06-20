package com.revature.shop_ui;

import com.revature.database.TempDatabase;
import com.revature.driver.Shop;

public class CustomerAccountPage implements UserScreens {
	TempDatabase db = Shop.db;
	
	CustomerAccountPage() {
		showItemList();
	}

	public void showItemList() {
		db.getItemList();
	}
	
	public void showCustomerOptions() {
		
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}
}
