package com.revature.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.util.CorsFix;

public class AuthServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private AuthService as = new AuthService();
	private ObjectMapper om = new ObjectMapper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException  {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + " " + password);

		try {
			User principal = as.login(username, password);
			
			HttpSession session = req.getSession();
			session.setAttribute("userId", principal.getId());
			session.setAttribute("userRole", principal.getUserTitle());
			
			String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";
			res.setHeader("Set-Cookie", cookie);
			
			UserDTO principalDTO = new UserDTO(principal);
			try(PrintWriter pw = res.getWriter()){
				System.out.println(om.writeValueAsString(principalDTO));
				pw.write(om.writeValueAsString(principalDTO));
				
				res.setStatus(200);
			}
		} catch (UserNotFoundException | LoginException e) {
			res.sendError(400, "Log in unsuccessfull");
			e.printStackTrace();
		}
		
	}
}
