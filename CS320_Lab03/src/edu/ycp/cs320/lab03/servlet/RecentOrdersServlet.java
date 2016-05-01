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
import edu.ycp.cs320.lab03.model.Order;

public class RecentOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GetOrder order = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		order = new GetOrder();
		ArrayList<Order> CustOrder = null;
		CustOrder = order.orderByUser(user);
		ArrayList<Integer> orderNum= new ArrayList<Integer>();
		for(int i=0; i<CustOrder.size(); i++){
			if(orderNum.isEmpty()){
				orderNum.add(CustOrder.get(0).getorderNumber());
			}
			else if(orderNum.contains(CustOrder.get(i).getorderNumber())){
				int count = 0;
			}
			else{
				orderNum.add(CustOrder.get(i).getorderNumber());
			}
		}
		Collections.reverse(orderNum);
		ArrayList<Integer> recents = new ArrayList<Integer>();
		if(orderNum.size()>5){
			for(int j=0; j<5; j++){
				recents.add(orderNum.get(j));
			}
		}
		else{
			for(int k=0; k<orderNum.size(); k++){
				recents.add(orderNum.get(k));
			}
		}
		req.setAttribute("orderNum", recents);
		req.getRequestDispatcher("/_view/RecentOrders.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		ArrayList<Order> OrderByNum = new ArrayList<Order>();
		int orderNumber = 0;
		orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
		order = new GetOrder();
		OrderByNum = order.orderByNum(orderNumber);
		String status = OrderByNum.get(0).getStatus();
		req.setAttribute("items", OrderByNum);
		req.setAttribute("status", status);
		req.setAttribute("recentOrders", OrderByNum);
		req.getRequestDispatcher("/_view/RecentOrders.jsp").forward(req, resp);
	}
}
