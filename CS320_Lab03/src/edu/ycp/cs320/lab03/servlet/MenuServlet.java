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
		String utype = null;
		String userType = (String) req.getSession().getAttribute("type");
		// Add parameters as request attributes
		if(userType.equals("owner")){
			utype = "owner";
		}
		req.setAttribute("utype", utype);
		//Create an array of menu items
		ArrayList<Menu> items = null;
		menu = new ViewMenuByRestaurantName();
		String rest_name = (String)req.getSession().getAttribute("restaurant");
		items = menu.menuByRestaurantName(rest_name);
		req.setAttribute("restaurant", rest_name);
		req.setAttribute("items", items);
		req.getRequestDispatcher("/_view/Menu.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		//Gets all the menu items selected by the user
		String[] order = null;

		
		//get menu items based on the restaurant name
		String[] qty = null; 
		qty = req.getParameterValues("quantity");
		if(qty!=null){
			int[] qtyInt = new int[qty.length];
			order = req.getParameterValues("itemName");
			// If there are items in order, build the order
			if(order != null){
				for(int i=0; i<qty.length; i++){
					if(qty[i].equals("") || qty[i]==null || qty[i].equals("0")){
						qty[i] = "0";
					}
					qtyInt[i] = Integer.parseInt(qty[i]);
				}
				System.out.println("coooll");
				req.getSession().setAttribute("qty", qtyInt);
				req.getSession().setAttribute("orderItems", order);
				resp.sendRedirect(req.getContextPath() + "/Order");
			}
		}
		else{
			req.getRequestDispatcher("/_view/Menu.jsp").forward(req, resp);
		}
	}
}