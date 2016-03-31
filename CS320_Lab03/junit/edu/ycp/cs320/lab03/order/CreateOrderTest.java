package edu.ycp.cs320.lab03.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Order;
import edu.ycp.cs320.lab03.controller.Restaurant;

public class CreateOrderTest {
	private Order testOrder; 
	private String Testitem;
	private Restaurant r;
	private float price;
	private boolean status; 
	@Before
	public void  setUp() throws Exception {
		testOrder = new Order(Testitem, r, status); 
	}
	
	@Test
	public void getConfirmationNumberTest() throws Exception {
		testOrder.getConfirmationNumber();
	}
	
	@Test
	public void getOrderPriceTest() throws Exception {
		
	}
}

