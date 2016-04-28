package edu.ycp.cs320.lab03.queries;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.controller.InitDatabase;
import edu.ycp.cs320.lab03.controller.User;

public class ConfirmUsernameWithPassword {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		
		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		//will need to be replaced by junit test data and servlet data
		System.out.print("Enter a user name: ");
		String name = keyboard.nextLine();
	
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		List<User> userList = db.matchUsernameWithPassword(name);
		//use this returned password for authentication in servlet
		for (User uList : userList) {
			System.out.println("found password: " + uList.getPassWord());
		}
	}
}
