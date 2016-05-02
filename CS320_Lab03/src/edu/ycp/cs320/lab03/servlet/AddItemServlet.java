package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab03.controllers.AddItemToMenu;
import edu.ycp.cs320.lab03.controllers.DeleteItemFromMenu;
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddItemToMenu add = null;
	private DeleteItemFromMenu delete = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("username");
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		
		req.getRequestDispatcher("/_view/AddItem.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		//Gets all the menu items selected by the user
		String message = null;
		String itemToRemove = null;
		String itemToAdd = null;
		Double NewItemPrice = 0.00;
		String rest_name = (String)req.getSession().getAttribute("restaurant");
		
		itemToRemove = req.getParameter("itemToRemove");
		itemToAdd = req.getParameter("item");
		if(itemToAdd!=null){	
			add = new AddItemToMenu();
			NewItemPrice = Double.parseDouble(req.getParameter("price"));
			add.AddItem(itemToAdd, NewItemPrice, rest_name);
			System.out.println("Success");
			message = "Success";
		}
		if(itemToRemove!=null){	
			delete = new DeleteItemFromMenu();
			delete.RemoveItem(itemToRemove);
			System.out.println("Success");
			message = "Success";
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("/_view/AddItem.jsp").forward(req, resp);
		
	}
}