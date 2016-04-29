package edu.ycp.cs320.lab03.query;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.model.Order;


public class buildOrder {
	private IDatabase db = null;
	public buildOrder() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public ArrayList<Order> createOrder(int patId, String rest, int orderNum, String item, Double price){
			List<Order> orderList = db.ceateOrderInTable(patId, rest, orderNum, item, price);
			ArrayList<Order> orders = null;
			
			if (orderList.isEmpty()) {
				System.out.println("No orders created");
				return null;
			}
			else {
				orders = new ArrayList<Order>();
				for (Order o : orderList) {
					orders.add(o);
				}			
			}
			
			
			return orders;
	}

}
