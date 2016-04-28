package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.queries.RestaurantSearch;
import edu.ycp.cs320.lab03.controller.ProjectController;
import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.model.User;

public class HomepageServlet extends HttpServlet {
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

		// now we have the user's User object,
		// proceed to handle request...
		req.getRequestDispatcher("/_view/Homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		String city = null;
		search = new RestaurantSearch();
		ArrayList<Restaurant> rest = null;
		city = req.getParameter("search");
		rest = search.RestByCity(city);;



		// Add parameters as request attributes
		req.setAttribute("rest", rest);
		req.setAttribute("search", city);
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);


		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Homepage.jsp").forward(req, resp);
	}

}
