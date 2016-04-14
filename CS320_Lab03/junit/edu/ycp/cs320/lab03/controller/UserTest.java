package edu.ycp.cs320.lab03.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab03.controller.Patron;


public class UserTest {
	private Patron patron;
	private Owner owner;
	@Before
	public void setUp() {
		patron = new Patron();
		patron.setUserName("meeps");
		patron.setPassWord("peeps");
		patron.setAccountInfo("Bob", "Smith", "bSmith@yahoo.com");
		patron.setAccountType("patron");
		
		owner = new Owner();
		owner.setAccountType("owner");
		owner.setPassWord("ragalfragal");
		owner.setUserName("BigFoot");
		owner.setAccountInfo("IC", "Moon", "ICMoon@gmail.com");
	}
	
	@Test
	public void testUsername() {
		String Username = patron.getUsername();
		assertEquals("meeps", Username);
		String username2 = owner.getUserName();
		assertEquals("BigFoot", username2);
	}
	@Test
	public void testPassword(){
		String Password = patron.getPassWord();
		assertEquals("peeps", Password);
		String password2 = owner.getPassWord();
		assertEquals("ragalfragal", password2);
	}
	@Test
	public void testFirstname(){
		String firstName = patron.getFirstName();
		assertEquals("Bob", firstName);
		String fname = owner.getFirstName();
		assertEquals("IC", fname);
	}
	@Test
	public void testLastname(){
		String lastName = patron.getLastName();
		assertEquals("Smith", lastName);
		String lName = owner.getLastName();
		assertEquals("Moon", lName);
	}
	@Test
	public void testEmail(){
		String email = patron.getEmail();
		assertEquals("bSmith@yahoo.com", email);
		String email2 = owner.getEmail();
		assertEquals("ICMoon@gmail.com", email2); 
	}
	
	@Test
	public void testGetAccountType() {
		String type1 = patron.getAccountType();
		String type2 = owner.getAccountType();
		assertEquals("patron", type1);
		assertEquals("owner", type2);
	}
}
