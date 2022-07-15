package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.NoNewRequestsException;
import com.revature.models.Request;
import com.revature.models.User;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class TestServlet2
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ObjectMapper om = new ObjectMapper();  
    private UserDAO ud = new UserHibernate();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);

		
		String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";
		res.setHeader("Set-Cookie", cookie);
		
		List<User> user = ud.retrieveUsers();
		
		try(PrintWriter pw = res.getWriter()){
			pw.write(om.writeValueAsString(user));
			res.setStatus(200);
		}
	}

}
