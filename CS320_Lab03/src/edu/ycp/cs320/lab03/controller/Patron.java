package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Patron extends User {
	
	private Address address;
	public ArrayList<Restaurant> favorites = new ArrayList<Restaurant>();
	public ArrayList<Order> savedOrders = new ArrayList<Order>();
	
	public Patron(String u, String p){
		super(u, p);
		
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addTofavorites(Restaurant rest){
		favorites.add(rest);
	}
	public Restaurant seeFavoriteRestaurantProfile(Restaurant r){
		for(int i = 0; i < favorites.size(); i++){
			if(favorites.get(i).getName().equals(r.getName())){
				return favorites.get(i);
			}
		}
		return null;
	}
	
	public void addToSavedOrders(Order o){
		savedOrders.add(o);
	}

}
