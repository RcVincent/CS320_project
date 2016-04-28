package edu.ycp.cs320.lab03.model;

import java.util.ArrayList;

public class Owner extends User {
	public ArrayList<Restaurant> myRestaurants = new ArrayList<Restaurant>();
	private int OwnerId;
	public Owner(/*String userName, String password*/) {
//		super(userName, password);
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
	public void buildMenu(String item, Double price, int i){
		myRestaurants.get(i).getMenu().addToMenu(item, price);
	}

	//for database
	public int getOwnerId() {
		return OwnerId;
	}


	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}
}
