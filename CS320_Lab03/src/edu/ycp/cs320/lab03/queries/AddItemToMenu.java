package edu.ycp.cs320.lab03.queries;

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
	public void AddItem(String item, Double price, String rest_name){
		
		db.addItemToMenu(item, price, rest_name);
	}
}
