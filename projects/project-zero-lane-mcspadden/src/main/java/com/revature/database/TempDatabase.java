package com.revature.database;

import java.util.ArrayList;

import com.revature.shopitems.Item;
import com.revature.shopitems.ItemState;
import com.revature.users.User;
import com.revature.users.UserTitle;

public class TempDatabase {
	private ArrayList<Item> items;
	private ArrayList<User> users;
	
	public TempDatabase() {
		initializeDatabases();
	}

	private void initializeDatabases() {
		items = new ArrayList<Item>();
		users = new ArrayList<User>();
		
		items.add(new Item("GameBoy Plus", "Console", 100.00f, ItemState.AVAILABLE));
		items.add(new Item("Nintendo WII", "Console", 145.00f, ItemState.PENDING));
		items.add(new Item("Acura TSX", "Car", 9145.00f, ItemState.AVAILABLE));
		
		users.add(new User("JamesR123", "Password", UserTitle.CLIENT));
		users.add(new User("SueZ242", "Password1", UserTitle.EMPLOYEE));
		users.add(new User("Hank232", "Password2", UserTitle.MANAGER));
	}
	
	public User searchUser(String userName) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(userName)) {
				return users.get(i);
			}
		}
		
		return null;
		
	}
	public void addUser(User u) {
		users.add(u);
	}
	
	public void getItemList() {
		System.out.println(
				"Item Number\tShop Item\t\t\tDescription\t\t\tPrice\tItem Status\n" +
				"===========\t=========\t\t\t===========\t\t\t=====\t===========\n"
				+ "");
		
		for(int i = 0; i < items.size(); i++) {
			System.out.print("     " + (i+1) + "\t\t" +
				  items.get(i).getItemName() + "\t\t\t" +
				  items.get(i).getItemDesc() + "\t\t\t\t" +
				  items.get(i).getPrice() +  "\t" +
				  items.get(i).getItemState() +"\n\n"); 
		}
	}
	
	public Item searchItem(String sku) {
		return null;

	}
	
	
}
