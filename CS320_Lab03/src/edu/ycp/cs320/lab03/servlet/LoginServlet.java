package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controller.AddNumbersController;
import edu.ycp.cs320.lab03.controller.Patron;
import edu.ycp.cs320.lab03.controller.ProjectController;
import edu.ycp.cs320.lab03.controller.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String errorMessage = null;

		try {
			String u = req.getParameter("username");

			String p = req.getParameter("password");

			ProjectController controller = new ProjectController();
			if(controller.authenticate(u, p)){

				req.getRequestDispatcher("/Homepage").forward(req, resp);
				//				User user = null;
				//				user.logIn(u, p);

			}
			else{
				errorMessage = "Incorrect Username or Password";
				req.setAttribute("errorMessage", errorMessage);

				req.getRequestDispatcher("/_view/Login.jsp").forward(req, resp);


			}
	

		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}

	}

}
