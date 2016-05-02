package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.GetOrder;
import edu.ycp.cs320.lab03.controllers.GetOrdersByRestaurant;
import edu.ycp.cs320.lab03.controllers.UpdateOrderStatus;
import edu.ycp.cs320.lab03.model.Order;

public class RestOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetOrdersByRestaurant orders = null;
	private GetOrder byNum = null;
	private UpdateOrderStatus update = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		orders = new GetOrdersByRestaurant();
		ArrayList<Order> order = null;
		String message = null;
		//get the restaurant name to be passed to the order call
		String rest = (String)req.getSession().getAttribute("restaurant");
		order = orders.OrdersbyRest(rest);
		
		//Array for the order numbers to be displayed
		ArrayList<Integer> orderNum= new ArrayList<Integer>();
		if(order!=null){
			//reverse the orders so the most recent one is displayed
			Collections.reverse(order);
			for(int i=0; i<order.size(); i++){
				if(orderNum.contains(order.get(i).getorderNumber()) || order.get(i).getStatus().equals("Complete")){
					int count = 0;
				}
				else{
					//add order number to the order array
					orderNum.add(order.get(i).getorderNumber());
				}
			}
		}
		else{
			message = "No Orders";
		}

		req.setAttribute("orderNum", orderNum);
		req.setAttribute("message", message);
		req.getRequestDispatcher("/_view/RestOrders.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Initialize variables
		ArrayList<Order> OrderByNum = new ArrayList<Order>();
		int orderNumber = 0;
		byNum = new GetOrder();
		update = new UpdateOrderStatus();
		String status = null;
		
		//get the order number
		orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
		//get the new status
		status = req.getParameter("status");
		if(status != null){
			update.changeStatus(status, orderNumber);
			System.out.println("success");
		}
		//get the items from the order
		OrderByNum = byNum.orderByNum(orderNumber);
		//set the variables
		req.setAttribute("orderNumber", orderNumber);
		req.setAttribute("items", OrderByNum);
		req.setAttribute("status", status);
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/RestOrders.jsp").forward(req, resp);
	}
}