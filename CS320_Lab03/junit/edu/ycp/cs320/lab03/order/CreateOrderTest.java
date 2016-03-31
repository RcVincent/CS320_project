package edu.ycp.cs320.lab03.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Order;

public class CreateOrderTest {
	private Order testOrder; 
	
	@Before
	public void  setUp() throws Exception {
		testOrder = new Order(null, null, false); 
	}
}
