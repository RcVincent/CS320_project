package edu.ycp.cs320.lab03.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab03.controller.Patron;


public class PatronTest {
	private Patron patron;
	private Restaurant rest;
	private Address add;
	@Before
	public void setUp(){
		add =  new Address(1, "John St.", "York", "PA", 18989);
		rest = new Restaurant("Italian Bar and Grill", add);
		patron = new Patron("meeps", "peeps");
		patron.addTofavorites(rest);
	}
	@Test
	public void testFavorites(){
		assertEquals(rest, patron.getRestaurantFromFavorites(0));
	}
}
