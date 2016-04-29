package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import edu.ycp.cs320.lab03.controller.ProjectController;

import edu.ycp.cs320.lab03.model.User;
import edu.ycp.cs320.lab03.query.ChangeUsername;
import edu.ycp.cs320.lab03.query.matchUsernameWithPassword;


public class ChangeAccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private matchUsernameWithPassword match = null;
	private ChangeUsername change = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		req.getRequestDispatcher("/_view/ChangeUsername.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		String username = null;
		String newUsername = null;
		String password = null;
		
		//get parameters from the jsp
		username = req.getParameter("username");
		newUsername = req.getParameter("newUsername");
		password = req.getParameter("password");
		
		//Validate login credentials
		match = new matchUsernameWithPassword();
		ArrayList<User> user = null;
		user = match.matchUser(username);
		if(user.size()>0){
			User u = user.get(0);
			ProjectController controller = new ProjectController();
			
			//if user is authenticated, call change password
			if(controller.authenticate(u, password)){
				change = new ChangeUsername();
				change.changeUsername(username, newUsername, password);
				
				//set session username to new username
				req.getSession().setAttribute("username", newUsername);
				errorMessage = "New username was successfully created";
				req.setAttribute("errorMessage", errorMessage);
				resp.sendRedirect(req.getContextPath() + "/Homepage");
			}
			else{
				
				errorMessage = "Incorrect Username or Password";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/_view/ChangeUsername.jsp").forward(req, resp);
			}
		}
		//otherwise, print an error message
	}

}