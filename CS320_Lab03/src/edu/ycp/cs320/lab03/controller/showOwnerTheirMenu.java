package edu.ycp.cs320.lab03.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;

public class showOwnerTheirMenu {
	private IDatabase db = null;
	public showOwnerTheirMenu() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public ArrayList<Menu> menuByOwner(String owner){
			List<Menu> menuList = db.seeMenuByOwner(owner);
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
