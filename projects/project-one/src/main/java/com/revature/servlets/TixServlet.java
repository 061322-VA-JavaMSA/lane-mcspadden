package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.NoNewRequestsException;
import com.revature.models.Request;
import com.revature.services.AuthService;
import com.revature.services.TixService;
import com.revature.util.CorsFix;


/**
 * Servlet implementation class TixServlet
 */
public class TixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TixService ts = new TixService();
	private ObjectMapper om = new ObjectMapper();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), res);

		
		try {
			String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";
			res.setHeader("Set-Cookie", cookie);
			
			List<Request> request = ts.generatePending();
			
			try(PrintWriter pw = res.getWriter()){
				pw.write(om.writeValueAsString(request));
				res.setStatus(200);
			}
		} catch (NoNewRequestsException e)  {
			res.sendError(400, "No new requests");
			e.printStackTrace();
		}
	}

}
