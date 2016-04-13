package edu.ycp.cs320.lab03.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab03.controller.Patron;


public class UserTest {
	private Patron patron;
	
	@Before
	public void setUp() {
		patron = new Patron();
		patron.setUserName("meeps");
		patron.setPassWord("peeps");
		patron.setAccountInfo("Bob", "Smith", "bSmith@yahoo.com");

	}
	
	@Test
	public void testUsername() {
		String Username = patron.getUsername();
		assertEquals("meeps", Username);
	}
	@Test
	public void testPassword(){
		String Password = patron.getPassWord();
		assertEquals("peeps", Password);
	}
	@Test
	public void testFirstname(){
		String firstName = patron.getFirstName();
		assertEquals("Bob", firstName);
	}
	@Test
	public void testLastname(){
		String lastName = patron.getLastName();
		assertEquals("Smith", lastName);
	}
	@Test
	public void testEmail(){
		String email = patron.getEmail();
		assertEquals("bSmith@yahoo.com", email);
	}
}
