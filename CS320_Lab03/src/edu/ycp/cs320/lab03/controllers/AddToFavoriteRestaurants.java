package edu.ycp.cs320.lab03.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.model.Favorites;

public class AddToFavoriteRestaurants {
	private IDatabase db = null;
	public AddToFavoriteRestaurants() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	
	}
	public void AddUser(String rest, Integer userId){
		
		db.addToFavoriteRests(rest, userId);
	}
public ArrayList<Favorites> GetFavs(Integer userId){
		
	List<Favorites> favList = db.getFromFavorites(userId);
	ArrayList<Favorites> favs = null;
	
	if (favList.isEmpty()) {
		System.out.println("No body wants your food");
		return null;
	}
	else {
		favs = new ArrayList<Favorites>();
		for (Favorites f : favList) {
			favs.add(f);
		}			
	}
	
	
	return favs;
	}
}
