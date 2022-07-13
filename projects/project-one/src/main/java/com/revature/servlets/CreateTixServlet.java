package com.revature.servlets;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.CouldNotCreateRequestException;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.models.RequestType;
import com.revature.services.AuthService;
import com.revature.services.EmailService;
import com.revature.services.TixService;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class CreateTixServlet
 */
public class CreateTixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO ud = new UserHibernate();
	private TixService ts = new TixService();
	private ObjectMapper om = new ObjectMapper();
	private EmailService es = new EmailService();

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		Request r = new Request();
		
		int ammount = Integer.parseInt(req.getParameter("ammount"));
		System.out.println(ammount);
		String desc = req.getParameter("desc");
		int author = Integer.parseInt(req.getParameter("author"));
	//	RequestType type = RequestType.valueOf(req.getParameter("type"));
		System.out.println(author);
		java.util.Date newD = new java.util.Date();
		Date sqlDate = new Date(newD.getTime());
		r.setDateSubmitted(sqlDate);
		r.setAmmount(ammount);
		r.setDesc(desc);
		r.setAuthor(ud.retrieveUserById(author));
		System.out.println(r.getAuthor().getId());
		r.setType(RequestType.LODGING);
		
		
		try {
			ts.createRequest(r);
		} catch (CouldNotCreateRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		es.sendEmailConfirm(r);

	}

}
