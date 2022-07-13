package com.revature.util;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailUtil {
	private static Session s;
	
	public static Session getSession() throws IOException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("email.properties"));
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if(s == null) {
			 s = Session.getInstance(prop, new Authenticator() {
			    @Override
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(username, password);
			    }
		});
		}
		return s;
	}
}
