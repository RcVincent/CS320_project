package edu.ycp.cs320.lab03.controller;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class AddUserToDatabase {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		
		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		//will need to be replaced by junit test data and servlet data
		System.out.print("Enter a user name: ");
		String name = keyboard.nextLine();
		System.out.print("Enter a user pswd: ");
		String pswd = keyboard.nextLine();
		System.out.print("Enter an email: ");
		String email = keyboard.nextLine();
		System.out.print("Enter the User type: ");
		String type = keyboard.nextLine();
		System.out.print("Enter a first name: ");
		String first = keyboard.nextLine();
		System.out.print("Enter a last name: ");
		String last = keyboard.nextLine();
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		List<User> userList = db.addUserToDatabase(name, pswd, email, type, first, last);	
		for (User uList : userList) {
			System.out.println("user Id: " + uList.getUserId() + " first name: " + uList.getFirstName() + " last name: " + 
					            uList.getLastName() + " email: " + uList.getEmail() + " user type " + uList.getAccountType() + 
					            " user name: " + uList.getUserName() + " password " + uList.getPassWord());
		}
	}
}
