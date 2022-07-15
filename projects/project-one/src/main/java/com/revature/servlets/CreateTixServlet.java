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
		String desc = req.getParameter("desc");
		int author = Integer.parseInt(req.getParameter("author"));
		RequestType type = RequestType.valueOf(req.getParameter("type"));
		String email = req.getParameter("email");
		Date date = new Date();




		r.setAmmount(ammount);
		r.setDesc(desc);
		r.setAuthor(ud.retrieveUserById(author));
		r.setType(type);
		r.setDateSubmitted(date);
		System.out.println(r.getAuthor().getId());
		
		
		try {
			ts.createRequest(r);
			res.setStatus(200);
		} catch (CouldNotCreateRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(email.equals("YES")) {
			es.sendEmailConfirm(r);
		} 

	}

}
