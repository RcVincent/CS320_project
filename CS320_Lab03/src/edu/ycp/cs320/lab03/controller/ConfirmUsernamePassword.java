package edu.ycp.cs320.lab03.controller;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class ConfirmUsernamePassword {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		
		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter a title: ");
		String name = keyboard.nextLine();

		IDatabase db = DatabaseProvider.getInstance();
		List <User> u = db.matchUsernameWithPassword(name);
//		for (Restaurant rList : restList) {
//			System.out.println("rest Id: " + rList.getRestID() + " name: " + rList.getName() + " address: " + 
//					            rList.getAddress() + " city " + rList.getCity() + " zip " + rList.getZipCode());
//		}
	}
}
