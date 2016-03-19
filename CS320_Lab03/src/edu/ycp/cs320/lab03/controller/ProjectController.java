package edu.ycp.cs320.lab03.controller;



public class ProjectController {
	private boolean LogStatus;


	public void Login(String username, String password) {
		

	}

	public void searchRestaurants(String search) {
		// TODO Auto-generated method stub
		//gonna search the database 

	}
	public void LogIn(User userName){
		userName.setStatus(true);
	}
	public void LogOut(User userName){
		userName.setStatus(false);
	}
}
