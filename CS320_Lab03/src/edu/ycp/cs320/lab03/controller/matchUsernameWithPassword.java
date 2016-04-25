package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class matchUsernameWithPassword {
	private IDatabase db = null;
	public matchUsernameWithPassword() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	
	}
	public ArrayList<User> matchUser(String name){
		List<User> userList = db.matchUsernameWithPassword(name);
		ArrayList<User> users = null;
		users = new ArrayList<User>();
		for (User user : userList) {
			users.add(user);
		}			
	// return authors for this title
	return users;
	}
}
