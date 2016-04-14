package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Patron extends User {
	private Order o;
	private Restaurant r;
	private Address address;
	public ArrayList<Restaurant> favorites = new ArrayList<Restaurant>();
	public ArrayList<Order> savedOrders = new ArrayList<Order>();
	public ArrayList<Restaurant> searchResults = new ArrayList<Restaurant>();
	public boolean saveOrder;

	public Patron(String u, String p){
		super(u, p);

	}
	
	private Restaurant getRestaurantFromSearchResults(int i){
		return searchResults.get(i);
	}
	
	private Restaurant getRestaurantFromFavorites(int i){
		return favorites.get(i);
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
		this.savedOrders.add(o);
	}

	public Order createOrder(Restaurant r, String itemToOrder, boolean savedOrder){
		this.o = new Order(itemToOrder, r, savedOrder);
		if(savedOrder){
			addToSavedOrders(o);
		}
		return o;
	}
	
	
	
	
	//this int will come from the jsp/controller based on the order it appears in the actual search results
	public float lookupPriceFromSearchResults(String item, int i){
		this.r = getRestaurantFromSearchResults(i);
		return r.getMenu().getItemPrice(item);
	}
	
	//the favorites will be numbered when viewed so the patron can input the into the jsp
	public float lookupPriceFromFromFavorites(String item, int i){
		this.r = getRestaurantFromFavorites(i);
		return r.getMenu().getItemPrice(item);
	}
	
	

}
