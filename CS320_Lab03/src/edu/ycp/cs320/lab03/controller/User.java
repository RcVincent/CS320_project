package edu.ycp.cs320.lab03.controller;


public class User {

	private String userName;
	private String passWord;
	private String email;
	private String firstName;
	private String lastName;
	private boolean status = false;


	public User(String fN, String lN, String userName, String pswd, String email){
		this.setUserName(userName);
		this.passWord = pswd;
		this.firstName = fN;
		this.lastName = lN;
		this.email = email;


	}
	public boolean getStatus(User userName) {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}

