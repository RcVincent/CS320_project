package edu.ycp.cs320.lab03.controller;

import java.util.Random;

public class Order{
	private String item;
	private float price = 0; //starts at zero as an accumulator
	private boolean takeOut;
	private Random confirmationNumber;
	
	
	public Order(String item, Restaurant r, boolean type){
		//get item and price from the menu passed from the restaurant
		this.price += r.getMenu().getItemPrice(item);
		this.item = item;
		this.takeOut = type;
		Random rnd = new Random();
		this.setConfirmationNumber(rnd);
	}


	public Random getConfirmationNumber() {
		return confirmationNumber;
	}


	public void setConfirmationNumber(Random confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	
	
	
	
	
	
	
	
}

