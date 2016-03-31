package edu.ycp.cs320.lab03.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Menu;
import edu.ycp.cs320.lab03.controller.Order;
import edu.ycp.cs320.lab03.controller.Restaurant;

public class CreateOrderTest {
	private Order testOrder;
	private Order testOrder2;

	private Restaurant r;
	private float price1 = (float) 10.99;
	private float price2 = (float) 4.99;

	private Menu testMenu1;
	
	
	
	@Before
	public void  setUp() throws Exception {
		
		testMenu1 = new Menu(); 
		
		
		testMenu1.addToMenu("pizza", price1);
		testMenu1.addToMenu("Sandwich", price2); 
		
		
		testOrder = new Order("Sandwich", r, false); 
		testOrder2 = new Order("omlette", r, true);
		
		
		
		
		testOrder2.fullOrder.put("omlette", price1);
		testOrder.fullOrder.put("Sandwich", price2);
		
	}
	
	@Test
	public void getConfirmationNumberTest() throws Exception {
		testOrder.getConfirmationNumber();
		testOrder2.getConfirmationNumber();
	}
	
	@Test
	public void getOrderPriceTest() throws Exception {
		testOrder.getPrice(); 
		testOrder2.getPrice(); 
	}
	
	@Test
	public void TestTakeOut() {
		assertFalse(testOrder.isTakeOut());
		assertTrue(testOrder2.isTakeOut());
	}
}

