package edu.ycp.cs320.lab03.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Restaurant;

public class CreateOrderTest {
	private Order testOrder;
	private Order testOrder2;
	
 
	private Restaurant r;
	
	private Double price1 = 10.99;
	private Double price2 = 4.99;

	private Menu testMenu1;
	private String pizza = "pizza"; 
	private String Sandwich = "Sandwich"; 
	
	@Before
	public void  setUp() throws Exception {
		
		testMenu1 = new Menu(); 
	
		
		
		
		r = new Restaurant(); 
		r.setMenu(testMenu1);
		
		r.getMenu().addToMenu(pizza, price1);
		r.getMenu().addToMenu(Sandwich, price2); 
			
		
		testOrder = new Order(); 
		testOrder2 = new Order();
		
		
		
		testOrder2.fullOrder.put("pizza", r.getMenu().getItemPrice("pizza"));
		testOrder.fullOrder.put("Sandwich", r.getMenu().getItemPrice("Sandwich"));
		
	}
	
	@Test
	public void getConfirmationNumberTest() throws Exception {
		testOrder.getorderNumber();
		testOrder2.getorderNumber();
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

