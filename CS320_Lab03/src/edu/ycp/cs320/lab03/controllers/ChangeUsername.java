package edu.ycp.cs320.lab03.controllers;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class ChangeUsername {
	private IDatabase db = null;
	public ChangeUsername() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	
	}
	public void changeUsername(String name, String newName, String pswd){
		
		db.changeUsername(name, newName, pswd);
	}
}
