package edu.ycp.cs320.lab03.controller;

public class Restaurant {
	private String Name;
	private Address address;
	private String description;
	
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
	public void addToMenu(){
		
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public void setDescription(String s){
		this.description.equals(s);
	}
	public String getDescription(){
		return this.description;
	}
	public void recieveOrder(Order o){
		throw new UnsupportedOperationException();
	}
}
