package edu.ycp.cs320.lab03.controller;



public class ProjectController {
	private boolean LogStatus;


	public void searchRestaurants(String search) {
		// TODO Auto-generated method stub
		//gonna search the database 

	}
	public void LogIn(User userName, String name){
		userName.setStatus(true);
	}
	public void LogOut(User userName){
		userName.setStatus(false);
	}
	
	public boolean authenticate(String u, String p)
	{
		boolean real = false;
		if(u.equals("meeps")&& p.equals("peeps")){
			real = true;
		}
		
		return real;
	}
	
	
}
