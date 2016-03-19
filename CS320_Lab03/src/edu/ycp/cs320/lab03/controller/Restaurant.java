package edu.ycp.cs320.lab03.controller;

public class Restaurant {
	private String Name;
	private Address address;
	
	public Restaurant(String n, Address a){
		this.setName(n);
		this.setAddress(a);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
