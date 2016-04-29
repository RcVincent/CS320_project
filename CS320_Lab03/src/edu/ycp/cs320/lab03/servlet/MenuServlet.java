package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.queries.ViewMenuByRestaurantName;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewMenuByRestaurantName menu = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		req.getRequestDispatcher("/_view/Menu.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		String[] orders = req.getParameterValues("Order");
		//Create an array of menu items
		ArrayList<Menu> items = null;
		menu = new ViewMenuByRestaurantName();
		String rest = (String) req.getSession().getAttribute("restaurant");
		//get menu items based on the restaurant name
		items = menu.menuByRestaurantName(rest);
		req.setAttribute("items", items);
		// If there are items in order, add them to session
		if(orders!= null){
			req.getSession().setAttribute("OrderItems", orders);
			resp.sendRedirect(req.getContextPath() + "/Order");
		}
		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Menu.jsp").forward(req, resp);
	}
}