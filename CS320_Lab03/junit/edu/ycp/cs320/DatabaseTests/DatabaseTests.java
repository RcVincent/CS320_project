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
import edu.ycp.cs320.lab03.model.Favorites;
import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Owner;
import edu.ycp.cs320.lab03.model.Patron;
import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.model.User;

public class DatabaseTests {
	private IDatabase db = null;

	List<Restaurant> restList = null;
	List<User> userList = null;
	List<User> users = null; 
	List<Menu> menu = null;
	List<Favorites> favList = null; 
	
	Menu m = null;
	List<Order> OrderList = null; 
	//The funcitons do not work if this is an arraylist. 
	
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
	public void getListOfRestaurantsByCity() throws Exception {
		System.out.println("\n*** Testing getListOfRestaurantsByCity ***");
		String city = "Boston TX"; 
		
		restList = db.getListOfRestaurantsByCity(city);
		// NOTE: this is a simple test to check if no results were found in the DB
		if (restList.isEmpty()) {
			System.out.println("No book found in library with title <" + city + ">");
			fail("No book with title <" + city + "> returned from Library DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
			ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
			for (Restaurant rest : restList) {
				Restaurant restAdd = rest;
				rests.add(restAdd);
				System.out.println(rest.getName() + "," + rest.getAddress() + ", " + rest.getCity() + "," + rest.getZipCode());
			}			
		}
	}
	@Test
	public void getRestByName() throws Exception{
		System.out.println("\n*** Testing getRestByName ***");
		String name = "Bakers Donuts"; 
		
		restList = db.getRestByName(name);
		// NOTE: this is a simple test to check if no results were found in the DB
		if (restList.isEmpty()) {
			System.out.println("No book found in library with title <" + name + ">");
			fail("No book with title <" + name + "> returned from Library DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
			ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
			for (Restaurant rest : restList) {
				Restaurant restAdd = rest;
				rests.add(restAdd);
				System.out.println(rest.getName() + "," + rest.getAddress() + ", " + rest.getCity() + "," + rest.getZipCode());
			}			
		}
	}
	
	@Test
	public void getListOfRestaurantsByOwner() throws Exception{
		System.out.println("\n*** Testing getListOfRestaurantsByOwner ***");
		String username = "theExpress"; 
		
		restList = db.getListOfRestaurantsByOwner(username);
		// NOTE: this is a simple test to check if no results were found in the DB
		if (restList.isEmpty()) {
			System.out.println("No restaurant found with owner name <" + username + ">");
			fail("No Owner with Account Name <" + username + "> returned from DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
			ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
			for (Restaurant rest : restList) {
				Restaurant restAdd = rest;
				rests.add(restAdd);
				System.out.println(rest.getName() + "," + rest.getAddress() + ", " + rest.getCity() + "," + rest.getZipCode());
			}			
		}
	}
	
	@Test
	public void addUserToDatabase() throws Exception{
		System.out.println("\n*** Testing addUserToDataBase ***");

		String name = "JimNacho56";
		String pswd = "theBest";
		String last = "Nacho";
		String first = "Jim";
		String email = "jNacho@aol.com";
		String type = "patron";
				
		// insert new user into DB
		users = db.addUserToDatabase(name, pswd, email, type, first, last);

		// check the return value
		if (users.size() > 0)
		{
			// try to retrieve the book and author from the DB
			// get the list of (Author, Book) pairs from DB
			userList = db.getAccountInfo(name);
			
			if (userList.isEmpty()) {
				System.out.println("No users found for Lastname <" + last + ">");
				fail("Failed to insert new book <" + name + "> into User DB");
			}
			// otherwise, the test was successful.  Now remove the book just inserted to return the DB
			// to it's original state, except for using an author_id and a book_id
			else {
				System.out.println("New user (username: " + name + ") successfully added to users table: <" + first + ">");
				
				// now delete Book (and its Author) from DB
				// leaving the DB in its previous state - except that an author_id, and a book_id have been used
				List<User> users = db.DeleteUserFromDatabase(name, pswd);				
			}
		}
	}
	
	@Test 
	public void MatchUsersWithPassword() throws Exception {
		System.out.println("\n*** Testing MatchUsersWithPassword ***"); 
		
		String userPassword = "pass"; 
		userList = db.matchUsernameWithPassword(userPassword); 

		if(userList.isEmpty()){
			System.out.println("No users matched to these passwords");
			fail("No users returned from the database");
		}
		else {
			List<User> users = new ArrayList<User>(); 
			for(User u : userList) {
				User UsertoAdd = u;
				users.add(UsertoAdd);
				System.out.println(u.getUserName() + ", " + u.getFirstName() + ", " + u.getLastName());
				
				//add a delete condition here or wait?
			}
		}
	}

	
	public void deleteUserFromDatabase() throws Exception {
		System.out.println("\n *** Removing Users from Database ***");
		String name = "userGuy"; 
		String password = "admin"; 
		String Fname = "John"; 
		String Lname = "Doe";
		String email = "jDoe@email.com"; 
		String type = "Patron"; 
		
		//Add to delete something 
		userList = db.addUserToDatabase(name, password, email, type, Fname, Lname); 
		
		//Can only delete when the list is populated 
		if(userList.size() > 0) {
			List<User> deletedUsers = db.DeleteUserFromDatabase(name, password);
			
			if(deletedUsers.isEmpty()) {
				System.out.println("Could not remove users from the databse with name <"+ name +">" );
				fail("No user(s) removed from the user database");
			}
			else {
				System.out.println("User" + deletedUsers.get(0).getUserName() + "removed from the user database"); 
			}
		}
	}

	@Test
	public void ChangeUserNameTest() {
		//SetUp
		 
		String name = "theDonald";
		String newName = "I am a Boss";
		String pswd = "pass";
		
		users = db.changeUsername(name, newName, pswd);
		if (users.size() > 0) {
			userList = db.getAccountInfo(newName);
			if (userList.isEmpty()) {
				System.out.println("New username <" + newName + "> not found in table");
				fail("Failed to change userName <" + name + "> to <" + newName + "> in user DB");
			}
			else {
				System.out.println("Changed username (username: " + name + ") successfully changed name to: <" + newName + ">");
				
				// 
				List<User> users = db.DeleteUserFromDatabase(name, pswd);				
			}
		}
		
	}

	@Test
	public void addItemToMenuTest() throws Exception {
		System.out.println("\n*** Testing addUserToDataBase ***");

		String item = "burritos";
		String price = "3.50";
		String restName = "Bakers Donuts";
				
		// insert new item into the menu DB
		menu = db.addItemToMenu(item, price, restName);

		// check the return value - should be menu.size() > 0
		if (menu.size() > 0)
		{
			// try to retrieve the book and author from the DB
			// get the list of (Author, Book) pairs from DB
			m = db.getPriceOfMenuItem(item);

			if (m == null) {
				System.out.println("No items called <" + item + ">");
				fail("Failed to insert new book <" + item + "> into menu DB");
			}
			// otherwise, the test was successful.  Now remove the book just inserted to return the DB
			// to it's original state, except for using an author_id and a book_id
			else {
				System.out.println("New item (item: " + item + ") successfully added to menu table: <" + price + ">");
				
				// now delete Book (and its Author) from DB
				// leaving the DB in its previous state - except that an author_id, and a book_id have been used
				Menu delMenu = db.deleteFromMenu(item);				
			}
		}

	}

	@Test
	public void getMenuByRestName() throws Exception {
		System.out.println("\n*** Testing getmenuByRestName ***");
		String rest = "Bakers Donuts"; 
		
		menu = db.menuByRestName(rest);
		// NOTE: this is a simple test to check if no results were found in the DB
		if (menu.isEmpty()) {
			System.out.println("No menu found for <" + rest + ">");
			fail("No menu for <" + rest + "> returned from Library DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
			System.out.println("Menu found for (rest: " + rest);
			
			// now delete Book (and its Author) from DB
			// leaving the DB in its previous state - except that an author_id, and a book_id have been used
			
			}			
		
	}

	//@Test
	public void getPriceOffMenuTest() throws Exception {
		//Set up
		String item = "Steak";
		String price = "5.50"; 
		String restName = "Trumps Steaks"; 
		
		menu = db.addItemToMenu(item, price, restName); 
		
		if (menu.size() > 0) {
		
			m = db.getPriceOfMenuItem(item);

			if (m == null) {
				System.out.println("No items called <" + item + ">");
				fail("Failed to insert items <" + item + "> into menu DB");
			}
			else {
				System.out.println("The item" + item + "has a price of" + price); 

				Menu delMenu = db.deleteFromMenu(item);	
			}
		
		}
	}		
		

	//@Test
	public void createOrderInTableTest() {

		
/*
		if(orderList.isEmpty()) {
			System.out.println("Why is no one ordering anything!?");
			fail("Manuel!!");
		}
		else {
			for (Order O: OrderList){
				OrderList.add(O); 
				System.out.println("Creating Orders"); 
			}
		}
*/

	}

	public void getAccountInfoTest() throws Exception {
		String Username1 = "theDonald";
		String Username2 = "theExpress";
		String Username3 = "userGuy";
		String Username4 = "anotherUser";
		List<User> listofUsers = new ArrayList<User>(); 
		
		listofUsers = db.getAccountInfo(Username1);
		assertEquals(1, listofUsers.size());
		
		listofUsers = db.getAccountInfo(Username2);
		assertEquals(2, listofUsers.size());
		
		listofUsers = db.getAccountInfo(Username3);
		assertEquals(3, listofUsers.size());
		
		listofUsers = db.getAccountInfo(Username4);
		assertEquals(4, listofUsers.size());
		
		if(listofUsers.isEmpty()) {
			System.out.println("There are no users to retrieve information for");
			fail("We need more users!");
		}
		else {
			//userlist = new ArrayList<User>(); 
			for(User u: listofUsers){
				//userlist.add(u);
				System.out.println(u.getUserName() + "," + u.getUserId()+ ","+ u.getEmail() + "," + u.getFirstName() + "," + u.getLastName());
			}
		}
	}


	public void getRestaurantsByOwnerTest() throws Exception {
		String OwnerName = "TheDonald";
		String NonOwnerName = "Some bum off the street";
		List<Restaurant>restaurantCount = new ArrayList<Restaurant>(); 

		System.out.println("*** Searching for Restaurants by Owner name ***");

		restaurantCount = db.getListOfRestaurantsByOwner(OwnerName);

		restaurantCount = db.getListOfRestaurantsByOwner(NonOwnerName);

		if(restaurantCount.isEmpty()) {
			System.out.println("That user has no restaurants");
			fail("Sorry for the confusion");
		}

		else {
			
			for(Restaurant r : restaurantCount) {
				//restlist.add(r);
				System.out.println(r.getName() + ", " + r.getAddress() + ", " + r.getCity() + ", " + r.getZipCode()); 
			}
		}
	}

	public void getOrderByConfirmNumber() throws Exception {

		Integer ConfirmNumber = 1345;
		List<Order> orderList = new ArrayList<Order>(); 

		orderList = db.getOrderByConfirmationNumber(ConfirmNumber);
		assertEquals(1, orderList.size());

		if(orderList.isEmpty()) {
			System.out.println("There are no orders with this number");
			fail("Re enter the order number");
		}
		else{
			OrderList = new ArrayList<Order>(); 
			for(Order o: orderList) {
				OrderList.add(o);
				System.out.println("Adding orders to the database");
			}
		}
	}

	public void deleteFromMenuTest() {
		//Need to add something in order to remove it 
		String item2 = "Special Brownies"; 
		Menu testMenu = new Menu(); 

		String Rest_ID = "Tom's Grill"; 
		List<Menu> menulist = new ArrayList<Menu>(); 

		//menulist = db.addItemToMenu(item2, 4.99, Rest_ID);

		//This is more like a regular JUnit test. 
		//The function looks like it returns items, not removes them.
		

	}

	public void getOrdersFromRestaurantTest() throws Exception{
		//Need to run the application to see how many orders there are. 
		String RestName = "Trump's Steaks"; 
		List<Order> orderlist = new ArrayList<Order>(); 

		orderlist = db.getOrdersByRestaurant(RestName); 
		assertEquals(2, orderlist.size()); 

		if(orderlist.isEmpty()) {
			System.out.println("There are no orders from that restaurant. Perhaps you can be the first");
			fail("Order something, then this will be populated"); 
		}
		else {
			OrderList = new ArrayList<Order>(); 
			for (Order o: orderlist) {
				OrderList.add(o);
				System.out.println("Adding orders to the list");
			}
		}
	}


	public void getOrderByPatronName() throws Exception{
		//Another one ill need to run the application to ensure the tests fully run. 
		String patronName = "userGuy"; 
		
		
		OrderList = db.getOrderByPatronUname(patronName);
		
		if(OrderList.isEmpty()) {
			System.out.println("This user has no orders");
			fail("Maybe this user shouldn't be such a slacker");
		}
		else{
			List<Order> Orders = new ArrayList<Order>(); 
			for (Order o: OrderList) {
				Order OrderToAdd = o; 
				Orders.add(OrderToAdd);
				System.out.println("Here are the orders for user <" + patronName + ">");
			}
		}
	}

	public void UpdateOrderStatusTest() {
		Order testOrder = new Order(); 
		if(OrderList.size() > 0) {
		
			List<Order> orderlist = new ArrayList<Order>(); 
			orderlist = db.updateOrderStatus(testOrder.getStatus(), testOrder.getorderNumber());
			
			if(orderlist.isEmpty()) {
				System.out.println("There are no orders to update");
				fail("Manuel!");
		}
			else {
				List<Order> Orders = new ArrayList<Order>(); 
				for(Order o : OrderList) {
					Order ordertoAdd = o; 
					Orders.add(ordertoAdd); 
					System.out.println("Updating order Status for order <" + ordertoAdd +">");
			}
		}
		}
	}

	@Test
	public void addToFavsTest() {	
		User testUser = new User(); 
		String restName1 = "Bakers Donuts"; 
		String restName2 = "Johnson";
		String restName3 = "Toms grill";
		String restName4 = "Trumps Steaks";
		
		favList = db.addToFavoriteRests(restName1, testUser.getUserId());
		favList = db.addToFavoriteRests(restName2, testUser.getUserId());
		favList = db.addToFavoriteRests(restName3, testUser.getUserId());
		favList = db.addToFavoriteRests(restName4, testUser.getUserId());
		
		if(favList.isEmpty()) {
			System.out.println("Cannot add favorites: its empty.");
			fail("Try searching again");
		}
		else {
			List<Favorites>  favs = new ArrayList<Favorites>();
			for(Favorites f : favList) {
				Favorites favToAdd = f; 
				favs.add(favToAdd); 
				System.out.println("Adding restaurant to user favorites");
			}
		}
	}
	
	
	public void getFromFavoritesTest() throws Exception {
		int userId = 1234; 
		favList = db.getFromFavorites(userId); 
		//I will continue work on this tomorrow 
	}
}


