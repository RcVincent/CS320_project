package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.GetOrder;
import edu.ycp.cs320.lab03.controllers.GetOrdersByRestaurant;
import edu.ycp.cs320.lab03.controllers.RestaurantSearch;
import edu.ycp.cs320.lab03.controllers.UpdateOrderStatus;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Restaurant;

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
		String rest = (String)req.getSession().getAttribute("restaurant");
		order = orders.OrdersbyRest(rest);
		ArrayList<Integer> orderNum= new ArrayList<Integer>();
		for(int i=0; i<order.size(); i++){
			if(orderNum.contains(order.get(i).getorderNumber())){
				int count = 0;
			}
			else{
				orderNum.add(order.get(i).getorderNumber());
			}
		}

		req.setAttribute("orderNum", orderNum);
		req.getRequestDispatcher("/_view/RestOrders.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<Order> OrderByNum = new ArrayList<Order>();
		int orderNumber = 0;
		orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
		byNum = new GetOrder();
		update = new UpdateOrderStatus();
		
		String status = null;
		status = req.getParameter("status");
		if(status != null){
			update.changeStatus(status, orderNumber);
		}
		OrderByNum = byNum.orderByNum(orderNumber);
		req.setAttribute("items", OrderByNum);
		req.setAttribute("status", status);
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/RestOrders.jsp").forward(req, resp);
	}
}