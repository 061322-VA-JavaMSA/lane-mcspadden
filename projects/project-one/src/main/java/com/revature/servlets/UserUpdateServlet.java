package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.models.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO ud = new UserHibernate();
		
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String id = req.getParameter("id");
		int id2 = Integer.parseInt(id);
		
		User u = ud.retrieveUserById(id2);
		
		u.setEmail(email);
		u.setUsername(username);
		u.setPassword(password);
		
		ud.updateUser(u);
		
	}

}
