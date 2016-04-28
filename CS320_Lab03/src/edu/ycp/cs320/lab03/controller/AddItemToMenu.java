package edu.ycp.cs320.lab03.controller;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class AddItemToMenu {
	private IDatabase db = null;
	public AddItemToMenu() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	
	}
	public void AddUser(String item, Double price, int rest_id){
		
		//db.addItemToMenu(item, price, rest_id);
	}
}
