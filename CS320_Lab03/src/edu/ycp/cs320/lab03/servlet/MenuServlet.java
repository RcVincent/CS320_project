package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controller.getAccountInfo;
import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.User;
import edu.ycp.cs320.lab03.queries.GetPriceOfMenuItem;
import edu.ycp.cs320.lab03.queries.ViewMenuByRestaurantName;
import edu.ycp.cs320.lab03.queries.buildOrder;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewMenuByRestaurantName menu = null;
	private GetPriceOfMenuItem price = null;
	private buildOrder newOrder = null;
	private getAccountInfo info = null;
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
		String[] orders = req.getParameterValues("Order");
		
		//Create an array of menu items
		ArrayList<Menu> items = null;
		menu = new ViewMenuByRestaurantName();
		
		String rest = (String) req.getSession().getAttribute("restaurant");
		//get menu items based on the restaurant name
		items = menu.menuByRestaurantName(rest);
		req.setAttribute("items", items);
		
		//get user account info for their userID
		info = new getAccountInfo();
		User u = info.getInfo((String)req.getSession().getAttribute("username")).get(0);
		
		//Build an order from the values the user selects
		Order orderNum = new Order();
		int num = orderNum.getorderNumber();
		req.getSession().setAttribute("orderNum", num);
		newOrder = new buildOrder();
		
		// If there are items in order, build the order
		if(orders != null){
			for(int i=0; i< orders.length; i++){
				Menu item = new Menu();
				price = new GetPriceOfMenuItem();
				item = price.priceOfItem(orders[i]);
				newOrder.createOrder(u.getUserId(), num, item.getItem(), item.getPrice());
			}
			resp.sendRedirect(req.getContextPath() + "/Order");
		}
		req.getRequestDispatcher("/_view/Menu.jsp").forward(req, resp);
	}
}