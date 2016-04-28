package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controller.ProjectController;

public class BakersDonutsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		req.getRequestDispatcher("/_view/Bakers Donuts.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		String rest = null;
		try {
			rest = req.getParameter("restaurant.name");


		} catch (NumberFormatException e) {
			errorMessage = "Invalid value";
		}
		
		// Add parameters as request attributes
		req.setAttribute("restName", rest);
		
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Bakers Donuts.jsp").forward(req, resp);
	}
}
