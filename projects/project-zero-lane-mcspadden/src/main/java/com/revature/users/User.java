/* Class: User
 * Purpose: This is a general class for users
 * 
 * 
 * 
 * 
 * 
 */
package com.revature.users;

import java.util.ArrayList;

import com.revature.shopitems.Item;

public class User {
	private String username;
	private String password;
	private UserTitle title;
	private ArrayList<Item> itemsOwned;
	
	public User() {
		
	}
	
	public User(String username, String password, UserTitle title) {
		this.username = username;
		this.password = password;
		this.title = title;
		itemsOwned = new ArrayList<Item>();
	}
	
	public void setOffer() {
		
	}
	
	public UserTitle getTitle() {
		return title;
	}
	public void setTitle(UserTitle title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
