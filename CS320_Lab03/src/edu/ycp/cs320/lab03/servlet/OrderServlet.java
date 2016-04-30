package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.GetOrder;
import edu.ycp.cs320.lab03.controllers.GetPriceOfMenuItem;
import edu.ycp.cs320.lab03.controllers.ViewMenuByRestaurantName;
import edu.ycp.cs320.lab03.controllers.buildOrder;
import edu.ycp.cs320.lab03.controllers.getAccountInfo;
import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.User;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ViewMenuByRestaurantName menu = null;
	private GetPriceOfMenuItem price = null;
	private buildOrder newOrder = null;
	private getAccountInfo info = null;
	private GetOrder NumOrder = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		info = new getAccountInfo();
		User u = info.getInfo((String)req.getSession().getAttribute("username")).get(0);
		String[] order = (String[])req.getSession().getAttribute("orderItems");
		
		//Build an order from the values the user selects
		Order orderNum = new Order();
		NumOrder = new GetOrder();
		int num = orderNum.getorderNumber();
		newOrder = new buildOrder();
		double total = 0;
		for(int i=0; i< order.length; i++){
			Menu item = new Menu();
			price = new GetPriceOfMenuItem();
			item = price.priceOfItem(order[i]);
			double ItemPrice = item.getPrice();
			total+=ItemPrice;
			newOrder.createOrder(u.getUserId(), (String)req.getSession().getAttribute("restaurant"), num, item.getItem(), ItemPrice);
		}
		ArrayList<Order> theOrder = NumOrder.orderByNum(num);
		req.setAttribute("order", theOrder);
		req.setAttribute("total", total);
		req.getRequestDispatcher("/_view/Order.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Order.jsp").forward(req, resp);
	}
}