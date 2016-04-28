package edu.ycp.cs320.lab03.queries;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.controller.Menu;

public class ViewMenuByRestaurantName {
	private IDatabase db = null;
	public ViewMenuByRestaurantName() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public ArrayList<Menu> menuByRestaurantName(String rest){
			List<Menu> menuList = db.menuByRestName(rest);
			ArrayList<Menu> menus = null;
			
			if (menuList.isEmpty()) {
				System.out.println("No menus found");
				return null;
			}
			else {
				menus = new ArrayList<Menu>();
				for (Menu m : menuList) {
					menus.add(m);
				}			
			}
			// return menus
			return menus;
	}
}
