package com.revature.modelview.pages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.daos.PlushDAO;
import com.revature.daos.PlushPostgres;
import com.revature.models.AnimePlush;
import com.revature.models.AnimePlushStatus;
import com.revature.models.Offer;
import com.revature.models.OfferStatus;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class EmployeePage implements Page {

	User employee = null;
	PlushDAO pd = new PlushPostgres();
	OfferDAO od = new OfferPostgres();
	Offer o = null;
	AnimePlush p = new AnimePlush();
	List<Offer> retrieved = null;
	List<AnimePlush> plushes = null;
	private static Logger log = LogManager.getLogger(Driver.class);

	
	public EmployeePage(User u) {
		employee = u;
		setUpPage();
	}
	
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to work " + employee.getUsername());
		setPageMenu();
	}

	@Override
	public void setPageMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1. View Offers\n" +
				"2. Add Items to Shop\n" +
				"3. Remove Items from Shop\n"	+
				"4. View Payment History\n" +
				"5. Log out\n"		
				);
		
		retrieveValidMenuChoice();
		
	}
	
	private void setSecondPageMenu() {
		// TODO Auto-generated method stub
		System.out.println(
				"1. Accept\n" + 
				"2. Reject\n" +
				"3. Go Back\n"
				);
		retrieveSecondMenuChoice();
	}


	private void retrieveSecondMenuChoice() {
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
			System.out.println("Please choose an offer to Accept");
			int choice = Driver.scan.nextInt();
			o = od.retrieveOffersById(choice);
			AnimePlush p = pd.retrievePlushById(o.getItem_id());
			p.setPrice(o.getOffer());
			p.setStatus(AnimePlushStatus.SOLD);
			o.setStatus(OfferStatus.ACCEPT);
			log.info("Accpted offer: " + o);
			od.updateOffer(o);
			pd.updatePlush(p);
			
			String sql = "insert into user_items_owned(user_id, item_id, balance) values (?,?,?)";
			
			try(Connection c1 = ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = c1.prepareStatement(sql);
				
				ps.setInt(1, o.getUser_id());
				ps.setInt(2, o.getItem_id());
				ps.setInt(3, o.getOffer());
				
				ps.execute();
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String dummy = Driver.scan.nextLine();
			sendToPage("EMPLOYEE", employee);
			break;
		case 2:
			System.out.println("Please choose an offer to Reject");
			int choice1 = Driver.scan.nextInt();
			Offer o1 = od.retrieveOffersById(choice1);
			AnimePlush p1 = pd.retrievePlushById(o1.getItem_id());
			p1.setStatus(AnimePlushStatus.AVAILABLE);
			o1.setStatus(OfferStatus.REJECT);
			log.info(employee.getUsername() + " rejected " + o);
			od.updateOffer(o1);
			pd.updatePlush(p1);
			sendToPage("EMPLOYEE", employee);
			break;
		case 3:
			sendToPage("EMPLOYEE", employee);
			break;
		}
	}

	@Override
	public void retrieveValidMenuChoice() {
		// TODO Auto-generated method stub
		String menuChoice = Driver.scan.nextLine();
		int c = Integer.parseInt(menuChoice);
		while(c != 1 && c != 2 && c != 3 && c != 4 && c != 5) {
			System.out.println("\nYou have entered an invalid menu choice\n");
			menuChoice = Driver.scan.nextLine();
			c = Integer.parseInt(menuChoice);
		}
		
		switch(c) {
		case 1:
			Driver.ClearConsole();
			retrieved = od.retrieveOffers();
			System.out.println(
					"\t###### SHOP ITEMS #######\n" +
					"OFFER ID\tITEM ID\tUSER ID\tOFFER\n" +
					"========\t=======\t=======\t=====\n"		
					);
			
			for(Offer o : retrieved) {
				System.out.println(
						o.getOffer_id() + "\t\t" +
						o.getItem_id() + "\t" +
						o.getUser_id() + "\t" +
						o.getOffer() + "\n"
						);
			}
			
			setSecondPageMenu();
			break;
		case 2:
			Driver.ClearConsole();
			System.out.println("Please enter the new item's name");
			String newName = Driver.scan.nextLine();
			System.out.println("Please enter the new item's description");
			String newDesc = Driver.scan.nextLine();
			System.out.println("Please enter the price of new item");
			int newPrice = Driver.scan.nextInt();
			
			p.setName(newName);
			p.setDescription(newDesc);
			p.setPrice(newPrice);
			p.setStatus(AnimePlushStatus.AVAILABLE);
			
			pd.createPlush(p);
			
			log.info("Plush Created: " + p);
			String dummy = Driver.scan.nextLine();
			sendToPage("EMPLOYEE", employee);
			
			break;
		case 3: 
			Driver.ClearConsole();
			plushes = pd.retrievePlush();
			System.out.println(
					"\n\n\t###### SHOP ITEMS #######\n" +
					"ITEM ID\tUSER ID\tPRICE\n" +
					"=======\t=======\t=====\n"		
					);
			
			for(AnimePlush p : plushes) {
				System.out.println(
						p.getId() + "\t" +
						p.getId() + "\t" +
						p.getPrice() + "\n"
						);
			}
			
			System.out.println("Which item would you like to remove?");
			int choice = Driver.scan.nextInt();
			String dummy2 = Driver.scan.nextLine();
			AnimePlush plush = pd.retrievePlushById(choice);
			System.out.println("Are you sure you want to remove " + plush.getName() + "? (Y or N)\n" +
					"This CANNOT be undone"
					);
			String choice2 = Driver.scan.next();
			choice2 = choice2.toUpperCase();

			while(!choice2.equals("Y") && !choice2.equals("N")) {
				System.out.println("You have entered an invalid option please type Y or N");
				choice2 = Driver.scan.nextLine();
			}

			if(choice2.equals("Y")) {
				log.info(employee.getUsername() + " Removed Plush: " + plush);
				pd.removePlush(choice);
			} 
			
			String dummy3 = Driver.scan.nextLine();
			sendToPage("EMPLOYEE", employee);
			break;
		case 4:
			Driver.ClearConsole();
			
			String sql = "select item_id, item_name, item_price from shopitems where item_state = CAST('SOLD' as status);";
			
			System.out.println(
					"\t#####ITEM BALANCES REPORT#####\n" +
					"ITEM ID\tITEM_NAME\tITEM_PRICE\n" +
					"=======\t=========\t==========\n"
					);
			try(Connection c1 = ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = c1.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getInt("item_id") + "\t" +
					rs.getString("item_name") + "\t" +
					rs.getInt("item_price") + "\t"
							);
					
				}
				
				System.out.println("\nPress enter to return");
				Driver.scan.nextLine();
				sendToPage("EMPLOYEE", employee);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				log.error(e);
				e.printStackTrace();
			}
			break;
		case 5:
			sendToPage("HOME", null);
			break;
		default:
			break;
		}
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
