package edu.ycp.cs320.lab03.controller;


public class User {

	String userName;
	String passWord;
	String email;
	String firstName;
	String lastName;
	boolean loggedIn;

	public User(String fN, String lN, String userName, String pswd, String email){
		this.userName = userName;
		this.passWord = pswd;
		this.firstName = fN;
		this.lastName = lN;
		this.email = email;
		loggedIn = true;
	}
	
}

