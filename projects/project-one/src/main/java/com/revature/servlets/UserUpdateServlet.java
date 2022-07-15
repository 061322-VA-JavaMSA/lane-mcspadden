package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.models.User;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class UserUpdateServlet
 */
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), res);

		String cookie = res.getHeader("Set-Cookie") + "; SameSite=None; Secure";

		UserDAO ud = new UserHibernate();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String id = req.getParameter("id");
		int id2 = Integer.parseInt(id);

		User u = ud.retrieveUserById(id2);

		u.setUsername(username);
		u.setPassword(password);


		ud.updateUser(u);
		res.setStatus(200);

	}

}
