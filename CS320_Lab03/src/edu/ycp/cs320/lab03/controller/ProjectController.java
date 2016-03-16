package edu.ycp.cs320.lab03.controller;



public class ProjectController {

	public void Login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	public void createAccount(String firstName, String lastName, String userName, String password, String email) {
		User newAccount = new User(firstName, lastName, userName, password, email);
	}

}
