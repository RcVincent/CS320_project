package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Owner extends User {
	public ArrayList<Restaurant> myRestaurants = new ArrayList<Restaurant>();
	
	public Owner(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}


	public void addToRestaurants(Restaurant rest){
		myRestaurants.add(rest);
	}
	public Restaurant seeRestaurantProfile(Restaurant r){
		for(int i = 0; i < myRestaurants.size(); i++){
			if(myRestaurants.get(i).getName().equals(r.getName())){
				return myRestaurants.get(i);
			}
		}
		return null;
	}
	
	//owner adds item to restaurant menu
	public void buildMenu(String item, Float price, int i){
		myRestaurants.get(i).getMenu().itemToAdd(item, price);
	}
}
