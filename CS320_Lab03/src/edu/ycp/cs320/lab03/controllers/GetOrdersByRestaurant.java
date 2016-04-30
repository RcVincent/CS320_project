package edu.ycp.cs320.lab03.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.model.Order;

public class GetOrdersByRestaurant {
	private IDatabase db = null;
	public GetOrdersByRestaurant() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public ArrayList<Order> OrdersbyRest(String rest){
			List<Order> ordersList = db.getOrdersByRestaurant(rest);
			ArrayList<Order> orders = null;
			
			if (ordersList.isEmpty()) {
				System.out.println("No body wants your food");
				return null;
			}
			else {
				orders = new ArrayList<Order>();
				for (Order o : ordersList) {
					orders.add(o);
				}			
			}
			
			
			return orders;
	}
}
