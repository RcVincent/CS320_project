package edu.ycp.cs320.lab03.queries;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.model.Menu;
import edu.ycp.cs320.lab03.model.Restaurant;

public class GetPriceOfMenuItem {
	private IDatabase db = null;
	public GetPriceOfMenuItem() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public ArrayList<Menu> priceOfItem(String item){
			List<Menu> mList = db.getPriceOfMenuItem(item);
			ArrayList<Menu> menus = null;
			
			if (mList.isEmpty()) {
				System.out.println("No restaurants found");
				return null;
			}
			else {
				menus = new ArrayList<Menu>();
				for (Menu m : mList) {
					menus.add(m);
				}			
			}
			return menus;
	}
}
