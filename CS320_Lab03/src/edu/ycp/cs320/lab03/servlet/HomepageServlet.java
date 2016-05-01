package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.lab03.controllers.RestaurantSearch;
import edu.ycp.cs320.lab03.model.Restaurant;

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
		//check whether user is owner
		String utype = null;
		String userType = (String) req.getSession().getAttribute("type");
		if(userType.equals("owner")){
			utype = "owner";
		}
		req.setAttribute("utype", utype);
		req.getRequestDispatcher("/_view/Homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Decode form parameters and dispatch to controller
		String city = null;
		//Call new restaurants search
		search = new RestaurantSearch();
		ArrayList<Restaurant> rest = null;
		//get parameters from jsp
		city = req.getParameter("search");
		rest = search.RestByCity(city);
		String utype = null;
		String userType = (String) req.getSession().getAttribute("type");
		// Add parameters as request attributes
		if(userType.equals("owner")){
			utype = "owner";
		}
		req.setAttribute("utype", utype);
		req.setAttribute("rest", rest);

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Homepage.jsp").forward(req, resp);
	}

}
