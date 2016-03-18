package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Patron {
	private User pat;
	private Address address;
	ArrayList<Restaurant> favorites = new ArrayList();
	ArrayList<Order> savedOrders = new ArrayList();
	
	public Patron(User user){
		this.setPat(user);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getPat() {
		return pat;
	}

	public void setPat(User pat) {
		this.pat = pat;
	}
	
}
