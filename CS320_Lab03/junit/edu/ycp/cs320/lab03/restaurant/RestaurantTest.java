package edu.ycp.cs320.lab03.restaurant;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Address;
import edu.ycp.cs320.lab03.controller.Order;
import edu.ycp.cs320.lab03.controller.Restaurant;

public class RestaurantTest {
	private Restaurant r;
	private Order TestOrder; 
	private Order TestOrder2;
	private Order TestOrder3;
	private Address add; 
	
	@Before
	public void setUp() throws Exception {
		add = new Address(175, "Jackson St", "York", "PA", 17403); 
		r = new Restaurant("Yorktown", add); 
		TestOrder = new Order("Large Pizza", r, false); 
		TestOrder2 = new Order("Medium Pizza", r, false);
		TestOrder3 = new Order("Small Pizza", r, false);
	}
	
	@Test
	public void getMenu() {
		r.getMenu();
	}
	
	@Test
	public void getOrder() {
		r.ordersList.add(TestOrder);
		r.ordersList.add(TestOrder2);
		r.ordersList.add(TestOrder3);
	}
	
	@Test
	public void findOrder() {
		r.ordersList.get(1);
	}
}
