package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Restaurant {
	private String Name;
	private Address address;
	private String description;
	private Menu menu;
	private Order o;
	private Review rev;
	public ArrayList<Review> reviews = new ArrayList<Review>();
	
	
	public Restaurant(String n){
		this.setName(n);
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
	public void setDescription(String s){
		this.description.equals(s);
	}
	public String getDescription(){
		return this.description;
	}
	public void recieveOrder(Order o){
		this.o = o;
	}
	//will get string and parsed int from controller
	public void writeReview(String s, int i){
		this.rev = new Review(s, i);
		reviews.add(rev);
	}
	public Menu getMenu(){
		return this.menu;
	}
}
