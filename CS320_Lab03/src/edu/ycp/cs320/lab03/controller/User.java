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
		this.setPassWord(pswd);
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	//available usernames/pswd's for authentication method
	public boolean authenticate(){
		return status;
		//TODO: hard code usernames and pswd's to send to the website
	}


}

