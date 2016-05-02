package edu.ycp.cs320.lab03.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.model.Restaurant;

public class RestaurantSearch {
	private IDatabase db = null;
	public RestaurantSearch() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public ArrayList<Restaurant> RestByCity(String city){
			List<Restaurant> restList = db.getListOfRestaurantsByCity(city);
			ArrayList<Restaurant> rests = null;
			
			if (restList.isEmpty()) {
				System.out.println("No restaurants found");
				return null;
			}
			else {
				rests = new ArrayList<Restaurant>();
				for (Restaurant rest : restList) {
					rests.add(rest);
				}			
			}
			
			// return authors for this title
			return rests;
	}
		public ArrayList<Restaurant> RestByOwner(String username){
			List<Restaurant> restList = db.getListOfRestaurantsByOwner(username);
			ArrayList<Restaurant> rests = null;
			
			if (restList.isEmpty()) {
				System.out.println("No restaurants found");
				return null;
			}
			else {
				rests = new ArrayList<Restaurant>();
				for (Restaurant rest : restList) {
					rests.add(rest);
				}			
			}
			
			// return authors for this title
			return rests;
	}
		public ArrayList<Restaurant> RestByName(String name){
			List<Restaurant> restList = db.getRestByName(name);
			ArrayList<Restaurant> rests = null;
			
			if (restList.isEmpty()) {
				System.out.println("No restaurants found");
				return null;
			}
			else {
				rests = new ArrayList<Restaurant>();
				for (Restaurant rest : restList) {
					rests.add(rest);
				}			
			}
			
			// return authors for this title
			return rests;
	}
}
