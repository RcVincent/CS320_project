package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

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
				System.out.println("No authors found in library");
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
