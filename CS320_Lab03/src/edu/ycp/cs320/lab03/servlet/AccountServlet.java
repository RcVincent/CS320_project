package edu.ycp.cs320.lab03.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.getAccountInfo;
import edu.ycp.cs320.lab03.model.User;



public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		
		req.getRequestDispatcher("/_view/Account.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String firstname = null;
		String lastname = null;
		String email = null;
		String username = (String) req.getSession().getAttribute("username");
		String AccountType = null;
		user = new getAccountInfo();
		ArrayList<User> u = user.getInfo(username);
		User use = u.get(0);
		firstname = use.getFirstName();
		lastname = use.getLastName();
		email = use.getEmail();
		username = use.getUsername();
		AccountType  = use.getAccountType();

		// Add parameters as request attributes
		req.setAttribute("firstname", firstname);
		req.setAttribute("lastname", lastname);
		req.setAttribute("email", email);
		req.setAttribute("username", username);
		req.setAttribute("AccountType", AccountType);
		

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Account.jsp").forward(req, resp);
	}
}