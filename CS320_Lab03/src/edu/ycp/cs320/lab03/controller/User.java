package edu.ycp.cs320.lab03.controller;


public abstract class User {
	private String userName;
	private String passWord;
	private String email;
	private String firstName;
	private String lastName;
	private boolean status = false;


	public User(String userName, String password, String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		this.userName = userName;
		this.passWord = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public boolean logIn(String username, String password) {
		// TODO Auto-generated method stub
		if(!status)
			status = true;
		return status;
	}

	//will update after presentation with SQL
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	
	//use database for this too
//	public boolean isOwner(String username){
//		
//	}


}

