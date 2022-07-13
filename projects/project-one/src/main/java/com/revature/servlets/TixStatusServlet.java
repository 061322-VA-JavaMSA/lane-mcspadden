package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.services.EmailService;
import com.revature.services.TixService;

/**
 * Servlet implementation class TixStatusServlet
 */
public class TixStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO ud = new UserHibernate();
	private TixService ts = new TixService();
	private ObjectMapper om = new ObjectMapper();
	private EmailService es = new EmailService();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
