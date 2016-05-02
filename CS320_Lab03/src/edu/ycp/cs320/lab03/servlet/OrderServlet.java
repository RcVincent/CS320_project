package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.GetOrder;
import edu.ycp.cs320.lab03.controllers.GetPriceOfMenuItem;
import edu.ycp.cs320.lab03.controllers.buildOrder;
import edu.ycp.cs320.lab03.controllers.getAccountInfo;
import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.User;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		//get account info of user in order to create an order based on their id
		info = new getAccountInfo();
		User u = info.getInfo((String)req.getSession().getAttribute("username")).get(0);
		String[] order = (String[])req.getSession().getAttribute("orderItems");
		int[] quantity = (int[])req.getSession().getAttribute("qty");
		int userId = u.getUserId();
	
		//Set the order number
		Order orderNum = new Order();
		int num = orderNum.getorderNumber();
		String rest = (String)req.getSession().getAttribute("restaurant");
		
		//initialize order variables
		//when user creates the order, it will always be pending
		NumOrder = new GetOrder();
		String status = "Pending";
		newOrder = new buildOrder();
		double total = 0;
		//goes through all items selected and builds the order
		for(int i=0; i< order.length; i++){
			if(quantity[i]!=0){
				Menu item = new Menu();
				price = new GetPriceOfMenuItem();
				item = price.priceOfItem(order[i]);
				Double ItemPrice = Double.parseDouble(item.getPrice());
				total+=quantity[i]*ItemPrice;
				newOrder.createOrder(userId, rest , num, item.getItem(), quantity[i], item.getPrice(), status);
			}
		}
		DecimalFormat df = new DecimalFormat("###.00");
		ArrayList<Order> theOrder = NumOrder.orderByNum(num);
		//set all attributes for the jsp
		req.setAttribute("order", theOrder);
		req.setAttribute("total", df.format(total));
		req.setAttribute("status", status);
		req.setAttribute("num", num);
		req.getRequestDispatcher("/_view/Order.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/Order.jsp").forward(req, resp);
	}
}