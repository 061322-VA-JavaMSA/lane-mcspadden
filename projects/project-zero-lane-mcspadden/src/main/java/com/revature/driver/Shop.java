package com.revature.driver;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.database.TempDatabase;
import com.revature.shop_ui.LoginScreen;

public class Shop {
	public static TempDatabase db = new TempDatabase();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:postgresql://ldm-project-zero.ctxmz3xkpwkl.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "";;
		
		try {
			Connection c = DriverManager.getConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
			java.sql.Statement s = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		while(true) {
			 LoginScreen login = new LoginScreen(db);
		}
	}

}
