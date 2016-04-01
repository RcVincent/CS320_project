
package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Restaurant {
	private String Name;
	private Address address;
	private String description;
	private Menu menu;
	public ArrayList<Review> reviews = new ArrayList<Review>();
	public ArrayList<Order> ordersList = new ArrayList<Order>();
	
	
	public Restaurant(String n, Address add){
		this.setName(n);
		this.setAddress(add);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
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
		this.ordersList.add(o);
	}
	public Order getOrder(int i){
		return this.ordersList.get(i);
	}
	

	public void addReview(Review i){
		this.reviews.add(i);

	}


	public Review readReview(int i){
		return this.reviews.get(i);
	}
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
