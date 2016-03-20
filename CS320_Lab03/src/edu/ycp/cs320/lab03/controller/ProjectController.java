package edu.ycp.cs320.lab03.controller;



public class ProjectController {


	public void searchRestaurants(String search) {
		// TODO Auto-generated method stub
		//gonna search the database 

	}

	
	public boolean authenticate(String u, String p)
	{
		boolean real = false;
		if(u.equals("meeps") && p.equals("peeps")){

			real = true;
		}
		
		return real;
	}
	public Order makeOrder(Order o){
		
		return o;
	}
}
