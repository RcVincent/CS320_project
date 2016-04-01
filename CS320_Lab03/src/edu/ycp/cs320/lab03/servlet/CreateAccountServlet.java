package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controller.AddNumbersController;
import edu.ycp.cs320.lab03.controller.Owner;
import edu.ycp.cs320.lab03.controller.Patron;
import edu.ycp.cs320.lab03.controller.ProjectController;
import edu.ycp.cs320.lab03.controller.User;


public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		String firstName = null;
		String lastName = null;
		String userName = null;
		String email = null;
		String password = null;
		String AccountType = null;
		try {
			firstName = req.getParameter("firstName");
			lastName = req.getParameter("lastName");
			userName = req.getParameter("userName");
			password = req.getParameter("password");
			email = req.getParameter("email");
			AccountType = req.getParameter("AccountType");

			if (userName == null || password == null || email == null
					|| firstName == null || lastName == null) {
				errorMessage = "Please fill in all fields";
				
			} else if(AccountType.equals("patron")){
				req.getSession().setAttribute("username", userName);
				req.getSession().setAttribute("firstname", firstName);
				req.getSession().setAttribute("lastname", lastName);
				req.getSession().setAttribute("email", email);
				req.getSession().setAttribute("AccountType", AccountType);
				resp.sendRedirect(req.getContextPath() + "/Homepage");
			} else if(AccountType.equals("owner")){
				req.getSession().setAttribute("username", userName);
				req.getSession().setAttribute("firstname", firstName);
				req.getSession().setAttribute("lastname", lastName);
				req.getSession().setAttribute("email", email);
				req.getSession().setAttribute("AccountType", AccountType);
				resp.sendRedirect(req.getContextPath() + "/Homepage");
			}
			else{
				req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid parameters";
		}
	}
}

