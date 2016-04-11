package edu.ycp.cs320.lab03.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab03.controller.Address;


public class AddressTest {
	private Address address;
	
	@Before
	public void setUp() {
		address = new Address(1, "Trump Ave.", "York", "PA", 17865);
	}
	
	@Test
	public void testHouseNumber() {
		int num = address.getHouseNumber();
		assertEquals(1, num);
	}
	@Test
	public void testStreetName(){
		String streetName = address.getStreet();
		assertEquals("Trump Ave.", streetName);
	}
	@Test
	public void testCity(){
		String city = address.getCity();
		assertEquals("York", city);
	}
	@Test
	public void testState(){
		String state = address.getState();
		assertEquals("PA", state);
	}
	@Test
	public void testZipcode(){
		int zipCode = address.getZipCode();
		assertEquals(17865, zipCode);
	}
}