package DBpersist;

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
				Integer.parseInt(i.next());
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
	
	// this db will hold the primary key for the restaurants
	public static List<Owner> getOwners() throws IOException {
		List<Owner> OwnerList = new ArrayList<Owner>();
		ReadCSV readOwners = new ReadCSV("owners.csv");
		try {
			// auto-generated primary key for table Owners
			Integer OwnerId = 1;
			while (true) {
				List<String> tuple = readOwners.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Owner owner = new Owner();
				
				// read Owner ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the Authors CSV file
				Integer.parseInt(i.next());
				// auto-generate Owner ID, instead
				owner.setOwnerId(OwnerId++);				
				owner.setFirstName(i.next());
				owner.setLastName(i.next());
				OwnerList.add(owner);
			}
			System.out.println("OwnerList loaded from CSV file");			
			return OwnerList;
		} finally {
			readOwners.close();
		}
	}

	public static List<Patron> getPatrons() throws IOException {
		List<Patron> PatronList = new ArrayList<Patron>();
		ReadCSV readPatrons = new ReadCSV("patrons.csv");
		try {
			// auto-generated primary key for table Patrons
			Integer PatronId = 1;
			while (true) {
				List<String> tuple = readPatrons.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Patron patron = new Patron();
				
				// read Patron ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the Authors CSV file
				Integer.parseInt(i.next());
				// auto-generate Patron ID, instead
				patron.setPatronId(PatronId++);				
				patron.setFirstName(i.next());
				patron.setLastName(i.next());
				PatronList.add(patron);
			}
			System.out.println("PatronList loaded from CSV file");			
			return PatronList;
		} finally {
			readPatrons.close();
		}
	}
	//user db will be for authentication and hold a primary key for patrons and Owners
	public static List<User> getUsers() throws IOException {
		List<User> UserList = new ArrayList<User>();
		ReadCSV readUser = new ReadCSV("User.csv");
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
				Integer.parseInt(i.next());
				// auto-generate User ID, instead
				User.setUserId(UserId++);				
//				User.setAuthorId(Integer.parseInt(i.next()));  // no longer in User table
				User.setUserName(i.next());
				User.setPassWord(i.next());
				User.setEmail(i.next());
				UserList.add(User);
			}
			System.out.println("UserList loaded from CSV file");			
			return UserList;
		} finally {
			readUser.close();
		}
	}
//	
//	// reads initial BookAuthor data from CSV file and returns a List of BookAuthors
//	public static List<BookAuthor> getBookAuthors() throws IOException {
//		List<BookAuthor> bookAuthorList = new ArrayList<BookAuthor>();
//		ReadCSV readBookAuthors = new ReadCSV("book_authors.csv");
//		try {
//			while (true) {
//				List<String> tuple = readBookAuthors.next();
//				if (tuple == null) {
//					break;
//				}
//				Iterator<String> i = tuple.iterator();
//				BookAuthor bookAuthor = new BookAuthor();
//				bookAuthor.setBookId(Integer.parseInt(i.next()));				
//				bookAuthor.setAuthorId(Integer.parseInt(i.next()));
//				bookAuthorList.add(bookAuthor);
//			}
//			System.out.println("bookAuthorList loaded from CSV file");			
//			return bookAuthorList;
//		} finally {
//			readBookAuthors.close();
//		}
//	}
}