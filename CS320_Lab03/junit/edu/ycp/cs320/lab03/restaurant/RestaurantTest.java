package edu.ycp.cs320.lab03.restaurant;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Restaurant;

public class RestaurantTest {
	private Restaurant r;
	//private ArrayList<Order> o;
	
	private Order TestOrder; 
	private Order TestOrder2;
	private Order TestOrder3;

	private Menu menu; 
	
	private Double price1 =  14.99;
	private Double price2 =  9.99; 
	private Double price3 =  6.99;
	
	
	@Before
	public void setUp() throws Exception {
		
		r = new Restaurant();
		menu = new Menu(); 
		r.setMenu(menu);
		
		r.getMenu().addToMenu("Large Pizza", price1);
		r.getMenu().addToMenu("Medium Pizza", price2);
		r.getMenu().addToMenu("Small Pizza", price3);
		
		
		
		TestOrder = new Order(); 
		TestOrder2 = new Order();
		TestOrder3 = new Order();
		
		r.ordersList.add(TestOrder);
		r.ordersList.add(TestOrder2);
		r.ordersList.add(TestOrder3);
	}
	
	
	
	@Test
	public void getOrder() {
		assertEquals(3, r.ordersList.size());
	}
	
	@Test
	public void findOrder() {
		r.getOrder(0);
		
	}
}
