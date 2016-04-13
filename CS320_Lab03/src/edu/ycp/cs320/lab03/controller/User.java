package edu.ycp.cs320.lab03.controller;

import java.util.Random;

public class User {
	private String userName;
	private String passWord;
	private String email;
	private String firstName;
	private String lastName;
	private String accountType;
	private int UserId;
	private boolean isOwner;
	private boolean status = false;
	private Random random;
	private int accountNumber;
	private final String ownType = "owner";
	private final String patType = "patron";

	public User(/*String userName, String password*/) {
//		// TODO Auto-generated method stub
//		this.setUserName(userName);
//		this.setPassWord(password);
		this.random = new Random();
		setAccountNumber(this.random.nextInt(100000));
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
		if(o){
			this.accountType = ownType;
		}else
			this.accountType = patType;
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
	public boolean isOwner() {
		return isOwner;
	}
	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}

