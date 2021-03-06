
package edu.ycp.cs320.lab03.model;

import java.util.ArrayList;

public class Restaurant {
	private String name;
	private String address;
	private String city;
	private String zipCode;
	private String description;
	private Menu menu;
	private int restID;
	private int UserId;
	private int patronFavId;
	public ArrayList<Review> reviews = new ArrayList<Review>();
	public ArrayList<Order> ordersList = new ArrayList<Order>();
	
	
	public Restaurant(){
	
//		this.setAddress(add);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
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
	//for database
	public int getRestID() {
		return restID;
	}

	public void setRestID(int restID) {
		this.restID = restID;
	}
// for database, foreign key
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int ownerId) {
		UserId = ownerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String string) {
		this.zipCode = string;
	}

	public int getPatronFavId() {
		return patronFavId;
	}

	public void setPatronFavId(int patronFavId) {
		this.patronFavId = patronFavId;
	}

	

}
