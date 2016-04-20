package edu.ycp.cs320.DatabaseTests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.controller.Owner;
import edu.ycp.cs320.lab03.controller.Patron;
import edu.ycp.cs320.lab03.controller.Restaurant;
import edu.ycp.cs320.lab03.controller.User;

public class DatabaseTests {
	private IDatabase db = null;

	ArrayList<Restaurant> restlist = null;
	List<Owner> ownerList = null;
	List<Patron> patronList = null;
	ArrayList<User> users = null; 


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());	
		db = DatabaseProvider.getInstance();

	}

	@After
	public void tearDown() throws Exception {
	}

	/*
		@Test
		public void testLoadUser() {

		}

		@Test
		public void testLoadOwner() {

		}

		@Test
		public void testLoadRestaurant() {

		}

		@Test
		public void testLoadPatron() {

		}
	 */
	
	@Test
	public void searchByCityName() {
		System.out.println("\n*** Searching for Restaurants by City ***");
		String city = "Houston AZ"; 

		List<Restaurant> restaurantCount = db.getListOfRestaurantsByCity(city);
		assertEquals(1, restaurantCount.size());

		String city2 = "Boston TX";
		restaurantCount = db.getListOfRestaurantsByCity(city2);
		assertEquals(2, restaurantCount.size());

		String city3 = "Paris";
		restaurantCount = db.getListOfRestaurantsByCity(city3);
		assertEquals(0, restaurantCount.size());
		
//		if(restaurantCount.isEmpty()) {
//			System.out.println("No Restaurants found in database");
//			fail("No restaurants returned from restaurant db");
//		}
//		else {
//			restlist = new ArrayList<Restaurant>(); 
//			for(Restaurant r : restaurantCount) {
//				restlist.add(r);
//				System.out.println(r.getName() + ", " + r.getAddress() + ", " + r.getCity() + ", " + r.getZipCode()); 
//			}
//		}
	}
	
	@Test 
	public void MatchUsersWithPassword() {
		System.out.println("\n*** Searching for Users ***"); 
		
		String userPassword = "pass"; 
		List<User> userList = db.matchUsernameWithPassword(userPassword); 
		assertEquals("theDonald", db.matchUsernameWithPassword(userPassword));
		
		String userPassword2 = "pswd";
		userList = db.matchUsernameWithPassword(userPassword2);
		assertEquals("theExpress", db.matchUsernameWithPassword(userPassword2)); 
		
		String userPassword3 = "passwd"; 
		userList = db.matchUsernameWithPassword(userPassword3);
		assertEquals("userGuy", db.matchUsernameWithPassword(userPassword3));
		
		String userPassword4 = "psswd"; 
		userList = db.matchUsernameWithPassword(userPassword4);
		assertEquals("anotherUser", db.matchUsernameWithPassword(userPassword4));
		
		if(userList.isEmpty()){
			System.out.println("No users matched to these passwords");
			fail("No users returned from the database");
		}
		else {
			users = new ArrayList<User>(); 
			for(User u : userList) {
				users.add(u); 
				System.out.println(u.getUserName() + ", " + u.getPassWord() + ", " + u.getFirstName() + ", " + u.getLastName());
			}
		}
	}

	
}
