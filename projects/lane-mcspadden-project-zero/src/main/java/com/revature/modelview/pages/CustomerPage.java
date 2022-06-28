package com.revature.modelview.pages;

import java.util.ArrayList;
import java.util.List;

import com.revature.Driver;
import com.revature.daos.PlushDAO;
import com.revature.daos.PlushPostgres;
import com.revature.models.AnimePlush;
import com.revature.models.User;

public class CustomerPage implements Page {
	User loggedIn;
	PlushDAO pd = new PlushPostgres();
	List<AnimePlush> list = new ArrayList<>();
	
	public CustomerPage(User u) {
		loggedIn = u;
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome " + loggedIn.getUsername() + " to the store!");
		System.out.println("Please select an option to continue!");
		setPageMenu();
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1. View Items in Shop\n" +
				"2. View Your Items\n" +
				"3. Logout\n"		
				);
		retrieveValidMenuChoice();
		
	}
	
	public void setOwnedMenu() {
		System.out.println(
				"1. Make Payment on Product\n" +
				"2. Go Back\n"	
				);
		retrieveSecondMenuChoice();
	}

	@Override
	public void retrieveValidMenuChoice() {
		// TODO Auto-generated method stub
		String menuChoice = Driver.scan.nextLine();
		int c = Integer.parseInt(menuChoice);
		while(c != 1 && c != 2 && c != 3) {
			System.out.println("\nYou have entered an invalid menu choice\n");
			menuChoice = Driver.scan.nextLine();
			c = Integer.parseInt(menuChoice);
		}
		
		switch(c) {
		case 1:
			Driver.ClearConsole();
			break;
		case 2:
			Driver.ClearConsole();
			viewOwnedItems(loggedIn, true);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	public void retrieveSecondMenuChoice() {
		String menuChoice = Driver.scan.nextLine();
		int c = Integer.parseInt(menuChoice);
		while(c != 1 && c != 2) {
			System.out.println("\nYou have entered an invalid menu choice\n");
			menuChoice = Driver.scan.nextLine();
			c = Integer.parseInt(menuChoice);
		}
		
		switch(c) {
		case 1:
			viewOwnedItems(loggedIn, false);
			System.out.println("Which Item Would you like to make a payment");
			int choice = Driver.scan.nextInt();
			AnimePlush choice1 = pd.retrievePlushById(choice);
			System.out.println(
					"You current balance on " + choice1.getName() + " is " + choice1.getPrice() + "\n" +
					"How much would you like to pay on it?"
					);
			int input = Driver.scan.nextInt();
			while(input > choice1.getPrice()) {
				System.out.println(
						"You cannot pay more than the remaining balance\n" + 
						"Value to pay must be less than " + choice1.getPrice() + "\n" +
						"Please enter a new figure");
				input = Driver.scan.nextInt();
			}
			int newBalance = choice1.getPrice() - input;
			
			choice1.setPrice(newBalance);
			pd.updatePlush(choice1);
			sendToPage("CUSTOMER", loggedIn);
			Driver.ClearConsole();
			break;
		case 2:
			Driver.ClearConsole();
			sendToPage("CUSTOMER", loggedIn);
			break;
		default:
			break;
		}
	}

	private void viewOwnedItems(User loggedIn2, boolean flag) {
		// TODO Auto-generated method stub
		list = pd.retrievePlushByUserId(loggedIn2.getId());
		
		System.out.println(
				"\t###### YOUR ITEMS #######\n" +
				"ITEM ID\tITEM NAME\tDESCRIPTION\t\tBALANCE\n" +
				"=======\t=========\t===========\t\t=======\n"		
				);
		for(AnimePlush each : list) {
			System.out.println(each.getId() + "\t"
		+ each.getName() + "\t"
		+ each.getDescription() + "\t"
		+ each.getPrice());
		}
		if(flag)
		setOwnedMenu();
		
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
