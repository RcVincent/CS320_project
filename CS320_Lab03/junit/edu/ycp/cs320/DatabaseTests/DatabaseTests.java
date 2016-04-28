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
				System.out.println(u.getUserName() + ", " + u.getPassWord() + ", " + u.getFirstName() + ", " + u.getLastName());
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
		assertEquals(3, userlist.size());


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
		assertEquals(3, userlist.size());

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
		String item1 = "pizza";
		String item2 = "hotdog";
		String item3 = "Special Brownies"; 
				
		//Load the items to the menu for this test case. 
		r.getMenu().addToMenu(item1, 10.99);
		r.getMenu().addToMenu(item2, 4.99);
		r.getMenu().addToMenu(item3, 29.99);
		
		List<Menu> menulist = db.addItemToMenu(item1, r.getMenu().getItemPrice(item1), r.getRestID());
		menulist = db.addItemToMenu(item2, r.getMenu().getItemPrice(item2), r.getRestID());
		menulist = db.addItemToMenu(item3, r.getMenu().getItemPrice(item3), r.getRestID());
		
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
		Menu m = new Menu(); 
		
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
		menulist = db.getPriceOfMenuItem(item1); 
		assertEquals(7.99, menulist.get(0).getItemPrice(item1), 0.001);
		
		menulist = db.getPriceOfMenuItem(item2);
		assertEquals(6.99, menulist.get(1).getItemPrice(item2), 0.001);
		
		menulist = db.getPriceOfMenuItem(item3);
		assertEquals(6.99, menulist.get(2).getItemPrice(item3), 0.001);
		
		if(menulist.isEmpty()){
			System.out.println("There is no menu present");
			fail("This has gotten rather silly"); 
		}
		//need another condition here for returns.	
	}
	
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
}

