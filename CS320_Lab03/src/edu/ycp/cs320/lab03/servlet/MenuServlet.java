package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.lab03.controllers.AddItemToMenu;
import edu.ycp.cs320.lab03.controllers.ViewMenuByRestaurantName;
import edu.ycp.cs320.lab03.model.Menu;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewMenuByRestaurantName menu = null;
	private AddItemToMenu add = null;
	
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
		//Gets all the menu items selected by the user
		String[] order = null;

		//Create an array of menu items
		ArrayList<Menu> items = null;
		menu = new ViewMenuByRestaurantName();
		
		//If user is an owner show them add item to menu
		String utype = null;
		String userType = (String) req.getSession().getAttribute("type");
		// Add parameters as request attributes
		if(userType.equals("owner")){
			utype = "owner";
		}
		req.setAttribute("utype", utype);
		String itemToAdd = (String) req.getAttribute("item");
		double NewItemPrice = 0;
		String rest_name = (String)req.getSession().getAttribute("restaurant");
		if(itemToAdd != null){
			add = new AddItemToMenu();
			NewItemPrice = (double) req.getAttribute("price");
			add.AddItem(itemToAdd, NewItemPrice, rest_name);
		}
		
		
		String rest = (String) req.getSession().getAttribute("restaurant");
		//get menu items based on the restaurant name
		items = menu.menuByRestaurantName(rest);
		req.setAttribute("items", items);
		order = req.getParameterValues("Order");
		// If there are items in order, build the order
		if(order != null){
			req.getSession().setAttribute("orderItems", order);
			resp.sendRedirect(req.getContextPath() + "/Order");
		}
		else{
			req.getRequestDispatcher("/_view/Menu.jsp").forward(req, resp);
		}
	}
}