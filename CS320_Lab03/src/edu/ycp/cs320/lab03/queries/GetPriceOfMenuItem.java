package edu.ycp.cs320.lab03.queries;



import edu.ycp.cs320.lab03.DBpersist.DatabaseProvider;
import edu.ycp.cs320.lab03.DBpersist.DerbyDatabase;
import edu.ycp.cs320.lab03.DBpersist.IDatabase;
import edu.ycp.cs320.lab03.model.Menu;


public class GetPriceOfMenuItem {
	private IDatabase db = null;
	public GetPriceOfMenuItem() {
		
		// Create the default IDatabase instance
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
		public Menu priceOfItem(String item){
			Menu MenItem = db.getPriceOfMenuItem(item);
			
			if (MenItem == null) {
				System.out.println("No restaurants found");
				return null;
			}

			return MenItem;
	}
}
