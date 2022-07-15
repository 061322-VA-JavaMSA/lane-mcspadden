package com.revature.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.RequestDAO;
import com.revature.daos.RequestHibernate;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.NoSuchRequestFoundException;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.services.EmailService;
import com.revature.services.TixService;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class TixStatusServlet
 */
public class TixStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO ud = new UserHibernate();
	private RequestDAO rd = new RequestHibernate();
	private TixService ts = new TixService();
	private ObjectMapper om = new ObjectMapper();
	private EmailService es = new EmailService();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		
		String status = req.getParameter("accden");
		String temp = req.getParameter("id");
		int reqId = Integer.parseInt(temp);
		int empId = Integer.parseInt(req.getParameter("emp_id"));
		Request toBeChanged = rd.retrieveRequestsById(reqId);
		toBeChanged.setStatus(RequestStatus.valueOf(status));
		Date date = new Date();
		toBeChanged.setDateResolved(date);
		toBeChanged.setCaseManager(ud.retrieveUserById(empId));
		

		es.sendEmailResult(toBeChanged);
		rd.updateRequest(toBeChanged);

	}

}
