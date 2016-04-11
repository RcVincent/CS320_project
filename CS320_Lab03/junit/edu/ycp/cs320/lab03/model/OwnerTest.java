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
	private Owner littleO;
	@Before
	public void setUp() throws Exception{
		BigO = new Owner("name", "password");
		BigO.addToRestaurants(r1);
		BigO.addToRestaurants(r2);
		littleO = new Owner("name1", "pass");
	}
	
	@Test
	public void addRestaurant() {
		assertEquals(2, BigO.myRestaurants.size());
	}
	
	@Test
public void getConfirmationNumberTest() throws Exception {
		
		System.out.println(BigO.getAccountNumber());
		System.out.println(littleO.getAccountNumber());
		assertNotEquals(BigO.getAccountNumber(), littleO.getAccountNumber());
	}
}
