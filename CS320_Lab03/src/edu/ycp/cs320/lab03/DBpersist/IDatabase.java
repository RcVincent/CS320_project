package edu.ycp.cs320.lab03.DBpersist;

import java.util.List;

import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Order;
import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.model.User;



public interface IDatabase {

	List<Restaurant> getListOfRestaurantsByCity(String name);

	List<User> matchUsernameWithPassword(String name);
	
	List<User> getAccountInfo(String name);

	List<User> addUserToDatabase(String name, String pswd, String email, String type, String first, String last);

	List<User> DeleteUserFromDatabase(String name, String pswd);

	List<User> changeUsername(String name, String newName, String pswd);

	List<Menu> addItemToMenu(String item, Double price, String rest_id);

	List<Restaurant> getListOfRestaurantsByOwner(String username);
	
	List<Menu> menuByRestName(String rest);

	Menu getPriceOfMenuItem(String item);

	List<Order> ceateOrderInTable(int patId, String rest, int orderNum, String item, Double price);

	List<Order> getOrderByConfirmationNumber(Integer orderNumber);

	Menu deleteFromMenu(String item);

	List<Order> getOrdersByRestaurant(String rest);

	List<Order> getOrderByPatronId(Integer patId);
	
}