package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.controller.RestaurantSearch;

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
		search = new RestaurantSearch();
		ArrayList<Restaurant> rest = null;
		String username = (String)req.getSession().getAttribute("username");
		rest = search.RestByOwner(username);
		req.setAttribute("rest", rest);
		req.getRequestDispatcher("/_view/OwnerPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Add parameters as request attributes
		//req.setAttribute("rest", req.getSession().getAttribute("rest"));
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/OwnerPage.jsp").forward(req, resp);
	}
}