package edu.ycp.cs320.lab03.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.model.Patron;
import edu.ycp.cs320.lab03.model.Restaurant;


public class PatronTest {
	private Patron patron;
	private Restaurant rest;

	@Before
	public void setUp(){
		rest = new Restaurant();
		patron = new Patron();
		patron.addTofavorites(rest);
	}
	@Test
	public void testFavorites(){
		assertEquals(rest, patron.getRestaurantFromFavorites(0));
	}
}
