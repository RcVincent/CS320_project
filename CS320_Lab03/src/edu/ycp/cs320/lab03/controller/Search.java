package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;

public class Search {

	Restaurant rest1 = new Restaurant("YCP restaurant", new Address(123, "york street", "York", "PA", 12345));
	Restaurant rest2 = new Restaurant("Austin's pizza", new Address(456, "rodeo drive", "Boston", "TX", 12356));
	Restaurant rest3 = new Restaurant("Wag's ribs", new Address(151, "bark court", "Boston", "TX", 45645));
	ArrayList<Restaurant> restList = new ArrayList<Restaurant>();


	private void fillRestaurantList(){
		restList.add(rest1);
		restList.add(rest2);
		restList.add(rest3);
	}

	public ArrayList<Restaurant> searchRestaurantsByName(String name){
		fillRestaurantList();

		ArrayList<Restaurant> resultList = new ArrayList<Restaurant>();
		for (int i = 0; i < restList.size(); i++){
			if(restList.get(i).getName().equals(name)){
				resultList.add(restList.get(i));
			}
		}

		return resultList;

	}
	public ArrayList<Restaurant> searchRestaurantsByCity(String city){
		fillRestaurantList();

		ArrayList<Restaurant> resultList = new ArrayList<Restaurant>();
		for (int i = 0; i < restList.size(); i++){
			if(restList.get(i).getName().equals(city)){
				resultList.add(restList.get(i));
			}
		}
		return resultList;
	}
}
