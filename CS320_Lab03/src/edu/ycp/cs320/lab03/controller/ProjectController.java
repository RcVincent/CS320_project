package edu.ycp.cs320.lab03.controller;

import java.awt.List;
import java.util.ArrayList;

import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Patron;
import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.model.Review;
import edu.ycp.cs320.lab03.model.Search;
import edu.ycp.cs320.lab03.model.User;

public class ProjectController {

	User u;
	

	public ArrayList<Restaurant> searchRestaurants(String searchVal, String params){
		Search search = new Search();

		ArrayList<Restaurant> searchResults = new ArrayList<Restaurant>();
		if(params.equals("name")){
			searchResults = search.searchRestaurantsByName(searchVal);
		}
//		}else if(params.equals("city")){
//			searchResults = search.searchRestaurantsByCity(searchVal);
//		}
		return searchResults;
	}




	
	public boolean authenticate(User u, String pswd)
	{
		boolean real = false;
		if(u.getPassWord().equals(pswd)){

			real = true;
		}
		
		return real;
	}
	//these next two will be accessed from the same servlet so the restaurant stays consistent
	public List viewMenuItems(Restaurant rest){
		return rest.getMenu().viewItems();
		
	}
	
	public Double getItemPrice(Menu menu, String item){
		return menu.getItemPrice(item);
	}
	
	
	
	public Order makeOrder(Restaurant rest, String itemToOrder, boolean saveOrder){
		Order o;
		if(!u.isOwner()){
			Patron p = new Patron();
			o = p.createOrder(rest, itemToOrder, saveOrder);
			rest.recieveOrder(o);
		}
		else{
			return null;
		}
		return o;		
	}
	public Order viewOrder(Restaurant rest, int order){
		//will pass the restaurant name from the session
		return rest.getOrder(order);
	}
	
	//will get string data from the servlet/jsp
	public void writeReview(Restaurant rest, String title, String review, int rating){
		Review rev = new Review(title, review, rating);
		rest.addReview(rev);
	}

}
