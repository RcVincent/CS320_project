package edu.ycp.cs320.lab03.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Address;
import edu.ycp.cs320.lab03.controller.Menu;
import edu.ycp.cs320.lab03.controller.Order;
import edu.ycp.cs320.lab03.controller.Restaurant;

public class OrderTest {
	private Order testOrder;
	private Order testOrder2;
	
	private Address add; 
	private Restaurant r;
	
	private Float price1 = (float) 10.99;
	private Float price2 = (float) 4.99;

	private Menu testMenu1;
	private String pizza = "pizza"; 
	private String Sandwich = "Sandwich"; 
	
	@Before
	public void  setUp() throws Exception {
		
		testMenu1 = new Menu(); 
	
		
		add = new Address(175, "Jackson St", "York", "PA", 17403); 
		
		r = new Restaurant("Name", add); 
		r.setMenu(testMenu1);
		
		r.getMenu().addToMenu(pizza, price1);
		r.getMenu().addToMenu(Sandwich, price2); 
			
		
		testOrder = new Order("Sandwich", r, false); 
		testOrder2 = new Order("pizza", r, true);
		
		
		
		testOrder2.fullOrder.put("pizza", r.getMenu().getItemPrice("pizza"));
		testOrder.fullOrder.put("Sandwich", r.getMenu().getItemPrice("Sandwich"));
		
	}
	
	@Test
	public void getConfirmationNumberTest() throws Exception {
		
		System.out.println(testOrder.getorderNumber());
		System.out.println(testOrder2.getorderNumber());
		assertNotEquals(testOrder2.getorderNumber(), testOrder.getorderNumber());
	}
	
	@Test
	public void getOrderPriceTest() throws Exception {
		testOrder.getPrice(); 
		testOrder2.getPrice(); 
	}
	
	@Test
	public void TestTakeOut() {
		assertFalse(testOrder.getTakeOut());
		assertTrue(testOrder2.getTakeOut());
	}
}

