package edu.ycp.cs320.lab03.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Owner;
import edu.ycp.cs320.lab03.controller.Restaurant;

public class OwnerTest {
	private Owner BigO;
	private Restaurant r1; 
	private Restaurant r2;
	@Before
	public void setUp() throws Exception{
		BigO = new Owner("name", "password");
		BigO.addToRestaurants(r1);
		BigO.addToRestaurants(r2);
	}
	
	@Test
	public void addRestaurant() {
		assertEquals(2, BigO.myRestaurants.size());
	}
}
