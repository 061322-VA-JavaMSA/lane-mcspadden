package com.revature.modelview.pages;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.daos.PaymentHistoryDAO;
import com.revature.daos.PaymentHistoryPostgres;
import com.revature.daos.PlushDAO;
import com.revature.daos.PlushPostgres;
import com.revature.models.AnimePlush;
import com.revature.models.AnimePlushStatus;
import com.revature.models.Offer;
import com.revature.models.OfferStatus;
import com.revature.models.Transaction;
import com.revature.models.User;

public class CustomerPage implements Page {
	public static User loggedIn;
	PlushDAO pd = new PlushPostgres();
	OfferDAO od = new OfferPostgres();
	PaymentHistoryDAO payd= new PaymentHistoryPostgres(); 
	List<AnimePlush> list = new ArrayList<>();
	private static Logger log = LogManager.getLogger(Driver.class);

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
			viewAllItems(true);
			break;
		case 2:
			Driver.ClearConsole();
			viewOwnedItems(loggedIn, true);
			break;
		case 3:
			sendToPage("HOME", null);
			break;
		default:
			break;
		}
	}
	
	private void viewAllItems(boolean flag) {
		// TODO Auto-generated method stub
		List<AnimePlush> all = new ArrayList<>();
		all = pd.retrievePlush();
		System.out.println(
				"\t###### SHOP ITEMS #######\n" +
				"ITEM ID\tITEM NAME\tDESCRIPTION\t\tPRICE\n" +
				"=======\t=========\t===========\t\t=======\n"		
				);
		
		for(AnimePlush each : all) {
			if(each.getStatus() != AnimePlushStatus.SOLD) {
				System.out.println(
						each.getId() + "\t" +
						each.getName() + "\t\t" +
						each.getDescription() + "\t\t\t" + 
						each.getPrice() + "\n"
						);
			}
		}
		if(flag)
		displayTertiaryMenu();
	}

	private void displayTertiaryMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1. Make an Offer on Product\n" +
				"2. Go Back\n"	
				);
		retrieveTertiaryMenuChoice();
	}

	private void retrieveTertiaryMenuChoice() {
		// TODO Auto-generated method stub
		String menuChoice = Driver.scan.nextLine();
		int c = Integer.parseInt(menuChoice);
		while(c != 1 && c != 2) {
			System.out.println("\nYou have entered an invalid menu choice\n");
			menuChoice = Driver.scan.nextLine();
			c = Integer.parseInt(menuChoice);
		}
		
		switch(c) {
		case 1:
			viewAllItems(false);
			System.out.println("Which item Would you like to make an offer on");
			int choice = Driver.scan.nextInt();
			AnimePlush choice1 = pd.retrievePlushById(choice);
			System.out.println(
					"Your suggested price on " + choice1.getName() + " is " + choice1.getPrice() + "\n" +
					"How much would you like to offer for it?"
					);
			int input = Driver.scan.nextInt();
			Offer o = new Offer();
			o.setItem_id(choice1.getId());
			o.setUser_id(loggedIn.getId());
			o.setOffer(input);
			o.setStatus(OfferStatus.PENDING);
			log.info("Offer Created: " + o);
			pd.updatePlush(choice1);
			log.info("Plush Updated : " + choice1);
			od.createOffer(o);
			String dummy = Driver.scan.nextLine();
			sendToPage("CUSTOMER", loggedIn);
			Driver.ClearConsole();
			break;
		case 2:
			sendToPage("CUSTOMER", loggedIn);
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
					"Your current balance on " + choice1.getName() + " is " + choice1.getPrice() + "\n" +
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
			Transaction t = new Transaction();
			int newBalance = choice1.getPrice() - input;
			t.setPayAmount(input);
			t.setBalance(newBalance);
			t.setUser_id(loggedIn.getId());
			t.setItem_id(choice1.getId());
			t.setEmp_authed(1);
			log.info(t);
			payd.addPaymentRecord(t);
			choice1.setPrice(newBalance);
			pd.updatePlush(choice1);
			
			//Transaction
			String dummy = Driver.scan.nextLine()	;	
			Driver.ClearConsole();
			sendToPage("CUSTOMER", loggedIn);

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
				"ITEM ID\tITEM NAME\tDESCRIPTION\t\tBALANCE\tMONTHLY PAYMENT REQUIRED\n" +
				"=======\t=========\t===========\t\t=======\t========================\n"		
				);
		for(AnimePlush each : list) {
			System.out.println(each.getId() + "\t"
		+ each.getName() + "\t\t"
		+ each.getDescription() + "\t\t"
		+ each.getPrice() + "\t" 
		+ each.getPrice()/10 + "\n");
		}
		if(flag)
		setOwnedMenu();
		
	}

	@Override
	public void sendToPage(String page, User u) {
		// TODO Auto-generated method stub
		Driver.mvc.navigate(page, u);
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

}
