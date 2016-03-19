package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controller.AddNumbersController;
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

		try {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String userName = req.getParameter("userName");
			String password = req.getParameter("passowrd");
			String email = req.getParameter("email address");
			

			if (userName == null || password == null || email == null
					|| firstName == null || lastName == null) {
				errorMessage = "Please fill in all fields";
				
			} else {
				ProjectController controller = new ProjectController();
				User newUser = new User(firstName, lastName, userName, password, email);
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid parameters";
		}

		// Add parameters as request attributes
		req.setAttribute("firstName", req.getParameter("firstName"));
		req.setAttribute("lastName", req.getParameter("lastName"));
		req.setAttribute("userName", req.getParameter("userName"));
		req.setAttribute("password", req.getParameter("password"));
		req.setAttribute("email", req.getAttribute("email"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);


		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/lab03/Homepage").forward(req, resp);
	}
}

