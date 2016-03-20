package edu.ycp.cs320.lab03.controller;


public abstract class User {
	private String userName;
	private String passWord;
	private String email;
	private String firstName;
	private String lastName;
	private boolean isOwner;
	private boolean status = false;


	public User(String userName, String password) {
		// TODO Auto-generated method stub
		this.setUserName(userName);
		this.setPassWord(password);
		
	}
	public void setAccountInfo(String fn, String ln, String email){
		this.firstName = fn;
		this.lastName = ln;
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
	public String getUsername(){
		return userName;
	}
	
//	//use database for this too
	public void isOwner(boolean o){
		this.isOwner = o;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

