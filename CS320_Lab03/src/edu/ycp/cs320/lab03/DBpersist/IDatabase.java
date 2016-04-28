package edu.ycp.cs320.lab03.DBpersist;

import java.util.List;

import edu.ycp.cs320.lab03.controller.Menu;
import edu.ycp.cs320.lab03.controller.Owner;
import edu.ycp.cs320.lab03.controller.Pair;
import edu.ycp.cs320.lab03.controller.Restaurant;
import edu.ycp.cs320.lab03.controller.User;

//import edu.ycp.cs320.booksdb.model.Author;
//import edu.ycp.cs320.booksdb.model.Book;
//import edu.ycp.cs320.booksdb.model.Pair;

public interface IDatabase {

	List<Restaurant> getListOfRestaurantsByCity(String name);

	List<User> matchUsernameWithPassword(String name);
	
	List<User> getAccountInfo(String name);

	List<User> addUserToDatabase(String name, String pswd, String email, String type, String first, String last);

	List<User> DeleteUserFromDatabase(String name, String pswd);

	List<User> changeUsername(String name, String newName, String pswd);

	//List<Menu> addItemToMenu(String item, Double price, int rest_id);
	
}