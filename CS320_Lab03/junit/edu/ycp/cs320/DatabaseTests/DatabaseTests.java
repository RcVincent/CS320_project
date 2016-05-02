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
import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Owner;
import edu.ycp.cs320.lab03.model.Patron;
import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.model.User;

public class DatabaseTests {
	private IDatabase db = null;

	ArrayList<Restaurant> restlist = null;
	List<Owner> ownerList = null;
	List<Patron> patronList = null;
	List<User> userlist = null;
	ArrayList<User> users = null; 
	ArrayList<Menu> MenuList = null;
	ArrayList<Order> OrderList = null; 

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
	public void searchByCityName() throws Exception {
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

		if(restaurantCount.isEmpty()) {
			System.out.println("No Restaurants found in database");
			fail("No restaurants returned from restaurant db");
		}
		else {
			restlist = new ArrayList<Restaurant>(); 
			for(Restaurant r : restaurantCount) {
				restlist.add(r);
				System.out.println(r.getName() + ", " + r.getAddress() + ", " + r.getCity() + ", " + r.getZipCode()); 
			}
		}
	}

	@Test 
	public void MatchUsersWithPassword() throws Exception {
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
			for(User u : users) {
				users.add(u); 
				System.out.println(u.getUserName() + ", " + u.getFirstName() + ", " + u.getLastName());
			}
		}
	}
	@Test
	public void addUserToDatabaseTest() throws Exception {
		System.out.println("\n*** Adding Users to Database ***");

		//SetUp
		User UserToBeEntered1 = new User(); 
		User UserToBeEntered2 = new User();
		User UserToBeEntered3 = new User(); 

		//Adding Users 
		userlist = db.addUserToDatabase(UserToBeEntered1.getUserName(), UserToBeEntered1.getPassWord(), UserToBeEntered1.getEmail(), UserToBeEntered1.getAccountType(), UserToBeEntered1.getFirstName(), UserToBeEntered1.getLastName());	
		userlist = db.addUserToDatabase(UserToBeEntered2.getUserName(), UserToBeEntered2.getPassWord(), UserToBeEntered2.getEmail(), UserToBeEntered2.getAccountType(), UserToBeEntered2.getFirstName(), UserToBeEntered2.getLastName());
		userlist = db.addUserToDatabase(UserToBeEntered3.getUserName(), UserToBeEntered3.getPassWord(), UserToBeEntered3.getEmail(), UserToBeEntered3.getAccountType(), UserToBeEntered3.getFirstName(), UserToBeEntered3.getLastName());


		//Test Cases
		//assertEquals(3, userlist.size());


		//Condition
		if(userlist.isEmpty()){
			System.out.println("No users were entered to the database");
			fail("Something has gone wrong. We will address this later.");
		}
		else {
			users = new ArrayList<User>(); 
			for(User u : users) {
				users.add(u); 
				System.out.println(u.getUserName() + ", " + u.getPassWord() + ", " +u.getEmail() + ", " +u.getAccountType() + ", "  + u.getFirstName() + ", " + u.getLastName());
			}
		}
	}

	@Test
	public void deleteUserFromDatabase() throws Exception {
		System.out.println("\n *** Removing Users from Database ***");


		//SetUp: copied from the test above to give us something to remove. 
		User UserToBeEntered1 = new User(); 
		User UserToBeEntered2 = new User();
		User UserToBeEntered3 = new User(); 

		//We need to set up these conditions for the removal function. 
		UserToBeEntered1.setUserName("User1");
		UserToBeEntered2.setUserName("User2");
		UserToBeEntered3.setUserName("User3");

		UserToBeEntered1.setPassWord("passWord");
		UserToBeEntered2.setPassWord("Guest");
		UserToBeEntered3.setPassWord("Admin"); 

		//Need to add something in order to delete it. 
		List<User> userlist = db.addUserToDatabase(UserToBeEntered1.getUserName(), UserToBeEntered1.getPassWord(), UserToBeEntered1.getEmail(), UserToBeEntered1.getAccountType(), UserToBeEntered1.getFirstName(), UserToBeEntered1.getLastName());	
		userlist = db.addUserToDatabase(UserToBeEntered2.getUserName(), UserToBeEntered2.getPassWord(), UserToBeEntered2.getEmail(), UserToBeEntered2.getAccountType(), UserToBeEntered2.getFirstName(), UserToBeEntered2.getLastName());
		userlist = db.addUserToDatabase(UserToBeEntered3.getUserName(), UserToBeEntered3.getPassWord(), UserToBeEntered3.getEmail(), UserToBeEntered3.getAccountType(), UserToBeEntered3.getFirstName(), UserToBeEntered3.getLastName());


		//Test Cases
		assertEquals(3, userlist.size()); //each time I run this test, at this point the number of users increases.

		userlist = db.DeleteUserFromDatabase("User1", "passWord");
		assertEquals(2, userlist.size()); 

		userlist = db.DeleteUserFromDatabase("User2", "Guest");
		assertEquals(1, userlist.size()); 

		userlist = db.DeleteUserFromDatabase("User3", "Admin");
		assertEquals(0, userlist.size()); 
		//Hopefully the database gets deincrememnted like specified. Can't remove 
		//two users at the same time(at least right now). 
	}

	@Test
	public void ChangeUserNameTest() {
		//SetUp
		User TestUser = new User(); 
		TestUser.setUserName("Imma Boss");
		TestUser.setPassWord("password");

		String newName = "I am a Boss"; 

		//Why am I getting an unused error here. 
		List<User> userlist = db.addUserToDatabase(TestUser.getUserName(), TestUser.getPassWord(), TestUser.getEmail(), TestUser.getAccountType(), TestUser.getFirstName(), TestUser.getLastName());

		userlist = db.changeUsername(TestUser.getUserName(), newName, TestUser.getPassWord()); 


		assertEquals("I am a Boss", TestUser.getUserName());

		//Only print the message when the operation is successful. 
		if(TestUser.getUserName() == newName) {
			System.out.println("\n*** Changing Username ***");
		}
	}

	@Test
	public void addItemToMenuTest() throws Exception {
		//Set up
		Restaurant r = new Restaurant(); 
		Menu menu = new Menu(); 
		String item1 = "pizza";
		String item2 = "hotdog";
		String item3 = "Special Brownies"; 

		//These caused a null pointer exception in the test. 
		//r.getMenu().addToMenu(item1, 10.99);
		//r.getMenu().addToMenu(item2, 4.99);
		//r.getMenu().addToMenu(item3, 29.99);

		//Load the items to the menu for this test case. 
		menu.addToMenu(item1, 10.99);
		menu.addToMenu(item2, 4.99);
		menu.addToMenu(item3, 29.99);

		List<Menu> menulist = db.addItemToMenu(item1, menu.getItemPrice(item1), r.getRestID());
		menulist = db.addItemToMenu(item2, menu.getItemPrice(item2), r.getRestID());
		menulist = db.addItemToMenu(item3, menu.getItemPrice(item3), r.getRestID());

		//Test to make sure that the items were added. 
		assertEquals(10.99, menulist.get(0).getItemPrice(item1), 0.001);
		assertEquals(4.99, menulist.get(1).getItemPrice(item2), 0.001);
		assertEquals(29.99, menulist.get(2).getItemPrice(item3), 0.001);

		assertEquals(3, menulist.size());
		if(menulist.isEmpty()) {
			System.out.println("Error. No items were added to the menu");
			fail("Something has gone terribly wrong"); 
		}
		else {
			MenuList= new ArrayList<Menu>(); 
			for(Menu m: MenuList) {
				MenuList.add(m);
				System.out.println("Adding Items"); 
			}
		}


	}

	@Test
	public void getMenuByRestName() throws Exception {
		//Set up
		Restaurant Rest = new Restaurant(); 
		String desiredName = "PizzaPain"; 
		Rest.setName("PizzaPain");

		List<Menu> menulist = new ArrayList<Menu>(); 
		menulist = db.menuByRestName(desiredName);

		if(menulist.isEmpty()) {
			System.out.println("No menus to find");
			fail("Manuel! Go get the Menus!");
		}
		else {
			for(Menu M: MenuList) {
				MenuList.add(M); //this needs to be revised I know it is wrong. 
				System.out.println("Retrieving Menu");
			}
		}

	}

	//@Test
	public void getPriceOffMenuTest() throws Exception {
		//Set up
		Menu m = new Menu();
		String item1 = "Pizza"; 
		String item2 = "Hamburger";
		String item3 = "Hit in Head";

		m.addToMenu(item1, 7.99);
		m.addToMenu(item2, 6.99);
		m.addToMenu(item3, 0.99);

		List<Menu> menulist = new ArrayList<Menu>();

		//Operations and conditions 
		menulist = (List<Menu>) db.getPriceOfMenuItem(item1); 
		assertEquals(7.99, menulist.get(0).getItemPrice(item1), 0.001);

		menulist = (List<Menu>) db.getPriceOfMenuItem(item2);
		assertEquals(6.99, menulist.get(1).getItemPrice(item2), 0.001);

		menulist = (List<Menu>) db.getPriceOfMenuItem(item3);
		assertEquals(6.99, menulist.get(2).getItemPrice(item3), 0.001);

		if(menulist.isEmpty()){
			System.out.println("There is no menu present");
			fail("This has gotten rather silly"); 
		}
		//need another condition here for returns.	
	}

	//@Test
	public void createOrderInTableTest() {

		Order o = new Order();
		Order o2 = new Order();
		Order o3 = new Order();
		Patron p = new Patron(); 
		Patron p2= new Patron(); 
		Restaurant r = new Restaurant();  
		Restaurant r2 = new Restaurant();  

		List<Order> orderList = new ArrayList<Order>(); 

		orderList = db.ceateOrderInTable(p.getPatronId(), o.getorderNumber(), r.getMenu().getItem(), r.getMenu().getItemPrice(r.getMenu().getItem()));
		assertEquals(1, orderList.size());
		orderList = db.ceateOrderInTable(p.getPatronId(), o2.getorderNumber(), r.getMenu().getItem(), r.getMenu().getItemPrice(r.getMenu().getItem()));
		assertEquals(2, orderList.size());
		orderList = db.ceateOrderInTable(p2.getPatronId(), o3.getorderNumber(), r2.getMenu().getItem(), r2.getMenu().getItemPrice(r2.getMenu().getItem()));
		assertEquals(1, orderList.size());

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
			userlist = new ArrayList<User>(); 
			for(User u: listofUsers){
				userlist.add(u);
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
		assertEquals(1, restaurantCount.size());

		restaurantCount = db.getListOfRestaurantsByOwner(NonOwnerName);
		assertNotEquals(2, restaurantCount.size()); 

		if(restaurantCount.isEmpty()) {
			System.out.println("That user has no restaurants");
			fail("Sorry for the confusion");
		}

		else {
			restlist = new ArrayList<Restaurant>(); 
			for(Restaurant r : restaurantCount) {
				restlist.add(r);
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

		menulist = db.addItemToMenu(item2, 4.99, Rest_ID);

		//This is more like a regular JUnit test. 
		//The function looks like it returns items, not removes them.
		testMenu = db.deleteFromMenu(item2); 

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
		List<Order> orderlist = new ArrayList<Order>(); 
		
		orderlist = db.getOrderByPatronUname(patronName);
		assertEquals(2, orderlist.size()); 
		
		if(orderlist.isEmpty()) {
			System.out.println("This user has no orders");
			fail("Maybe this user shouldn't be such a slacker");
		}
		
		else{
			OrderList = new ArrayList<Order>(); 
			for (Order o: orderlist) {
				OrderList.add(o);
				System.out.println("Adding user orders to the database");
			}
		}
	}

	public void UpdateOrderStatusTest() {
		Order testOrder = new Order(); 
		List<Order> orderlist = new ArrayList<Order>(); 
		orderlist = db.updateOrderStatus(testOrder.getStatus(), testOrder.getorderNumber());
		if(orderlist.isEmpty()) {
			System.out.println("There are no orders to update");
			fail("Manuel!");
		}
		else {
			OrderList = new ArrayList<Order>(); 
			for(Order o : orderlist) {
				OrderList.add(o);
				System.out.println("");
			}
		}
	}

	public void addToFavsTest() {
		
		User testUser = new User(); 
		String restName1 = "Bakers Donuts"; 
		String restName2 = "Johnson";
		String restName3 = "Toms grill";
		String restName4 = "Trumps Steaks";
		List<Restaurant> restList = new ArrayList<Restaurant>(); 
		
		restList = db.addToFavoriteRests(restName1, testUser.getUserId());
		assertEquals(4, restList.size());
		
		restList = db.addToFavoriteRests(restName2, testUser.getUserId());
		assertEquals(4, restList.size());
		
		restList = db.addToFavoriteRests(restName3, testUser.getUserId());
		assertEquals(4, restList.size());
		
		restList = db.addToFavoriteRests(restName4, testUser.getUserId());
		assertEquals(4, restList.size());
		
		if(restList.isEmpty()) {
			System.out.println("Cannot add restaurant to favorites list");
			fail("Try searching again");
		}
		else 
			restlist = new ArrayList<Restaurant>(); 
			for(Restaurant r : restList) {
				restlist.add(r);
				System.out.println("Adding restaurant to user favorites");
			}
	}
}


