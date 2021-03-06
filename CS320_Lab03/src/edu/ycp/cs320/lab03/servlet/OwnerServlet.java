package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.RestaurantSearch;
import edu.ycp.cs320.lab03.model.Restaurant;

public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantSearch search = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		//Initialize variables
		search = new RestaurantSearch();
		ArrayList<Restaurant> rest = null;
		//search restaurants by owner
		rest = search.RestByOwner(user);
		req.setAttribute("rest", rest);
		req.getRequestDispatcher("/_view/OwnerPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/OwnerPage.jsp").forward(req, resp);
	}
}