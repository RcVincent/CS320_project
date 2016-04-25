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
	
	 
	private Restaurant r;
	
	private Double price1 = (Double) 10.99;
	private Double price2 = (Double) 4.99;

	private Menu testMenu1;
	private String pizza = "pizza"; 
	private String Sandwich = "Sandwich"; 
	
	@Before
	public void  setUp() throws Exception {
		
		testMenu1 = new Menu(); 
		r = new Restaurant(); 
		r.setName("Yorktown");
		r.setAddress("123 4th street");
		r.setCity("york");
		r.setZipCode("12356");
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

