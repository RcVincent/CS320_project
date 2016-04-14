package edu.ycp.cs320.lab03.controller;

public class Address {
	private int houseNumber;
	private String street;
	private String city;
	private String state;
	private int zipCode;
	
	public Address(int n, String st, String c, String state, int z){
		this.setHouseNumber(n);
		this.setStreet(st);
		this.setCity(c);
		this.setState(state);
		this.setZipCode(z);
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
