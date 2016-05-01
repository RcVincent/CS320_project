package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.PsuedoController.AddNumbersController;
import edu.ycp.cs320.lab03.PsuedoController.ProjectController;
import edu.ycp.cs320.lab03.controllers.AddUserToDatabase;
import edu.ycp.cs320.lab03.controllers.RestaurantSearch;
import edu.ycp.cs320.lab03.model.Owner;
import edu.ycp.cs320.lab03.model.Patron;
import edu.ycp.cs320.lab03.model.User;


public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddUserToDatabase AddUser = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//initialize variables
		String firstName = null;
		String lastName = null;
		String userName = null;
		String email = null;
		String password = null;
		String AccountType = null;
		
		//get values from the jsp
		firstName = req.getParameter("firstName");
		lastName = req.getParameter("lastName");
		userName = req.getParameter("userName");
		password = req.getParameter("password");
		email = req.getParameter("email");
		AccountType = req.getParameter("AccountType");
		
		//set session username
		req.getSession().setAttribute("username", userName);
		
		//Create add user instance
		AddUser = new AddUserToDatabase();	
		//Adds the user to the database
		AddUser.AddUser(userName, password, email, AccountType, firstName, lastName);
		//Redirect to login page
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
	}
}

