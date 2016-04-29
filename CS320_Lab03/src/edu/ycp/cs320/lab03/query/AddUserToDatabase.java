package edu.ycp.cs320.lab03.query;


import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class AddUserToDatabase {
	private IDatabase db = null;
	public AddUserToDatabase() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	
	}
	public void AddUser(String name, String pswd, String email, String type, String first, String last){
		
		db.addUserToDatabase(name, pswd, email, type, first, last);
	}
}
