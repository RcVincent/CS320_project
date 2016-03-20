package edu.ycp.cs320.lab03.controller;

public class Address {
	private int number;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public Address(int n, String st, String c, String state, int z){
		this.number = n;
		this.street = st;
		this.city = c;
		this.state = state;
		this.zip = z;
	}
	
}
