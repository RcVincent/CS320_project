package edu.ycp.cs320.lab03.controllers;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class UpdateOrderStatus {
	private IDatabase db = null;
	public UpdateOrderStatus() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	
	}
	public void changeStatus(String status, int orderNum){
		
		db.updateOrderStatus(status, orderNum);
	}
}
