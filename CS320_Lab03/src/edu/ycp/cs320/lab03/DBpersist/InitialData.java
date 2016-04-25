package edu.ycp.cs320.lab03.DBpersist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.lab03.controller.Owner;
import edu.ycp.cs320.lab03.controller.Restaurant;
import edu.ycp.cs320.lab03.controller.Patron;
import edu.ycp.cs320.lab03.controller.Menu;
import edu.ycp.cs320.lab03.controller.Review;
import edu.ycp.cs320.lab03.controller.User;

public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	public static List<Restaurant> getRestaurants() throws IOException {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		ReadCSV readRestaurants = new ReadCSV("restaurants.csv");
		try {
			// auto-generated primary key for authors table
			Integer restId = 1;
			while (true) {
				List<String> tuple = readRestaurants.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Restaurant rest = new Restaurant();

				// read restaurant ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				//Integer.parseInt(i.next());
				rest.setRestID(restId++);				
				rest.setName(i.next());
				rest.setAddress(i.next());
				rest.setCity(i.next());
				rest.setZipCode(i.next());
				restaurantList.add(rest);
			}
			System.out.println("restaurantList loaded from CSV file");
			return restaurantList;
		} finally {
			readRestaurants.close();
		}
	}

	//user db will be for authentication and hold a primary key for patrons and Owners
	public static List<User> getUsers() throws IOException {
		List<User> UserList = new ArrayList<User>();
		ReadCSV readUser = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for table User
			Integer UserId = 1;
			while (true) {
				List<String> tuple = readUser.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User User = new User();

				// read User ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the Authors CSV file
				
				// auto-generate User ID, instead
				User.setUserId(UserId++);				
				User.setUserName(i.next());
				User.setPassWord(i.next());
				User.setEmail(i.next());
				User.setAccountType(i.next());
				User.setFirstName(i.next());
				User.setLastName(i.next());
				UserList.add(User);
			}
			System.out.println("UserList loaded from CSV file");			
			return UserList;
		} finally {
			readUser.close();
		}
	}
}