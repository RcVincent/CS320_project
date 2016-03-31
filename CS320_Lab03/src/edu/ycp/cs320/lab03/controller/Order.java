package edu.ycp.cs320.lab03.controller;

import java.util.Random;
import java.util.TreeMap;

public class Order{
	private float price = 0; //starts at zero as an accumulator
	private boolean takeOut;
	private Random confirmationNumber;
	public TreeMap<String, Float> fullOrder = new TreeMap<String, Float>();
	
	
	public Order(String item, Restaurant r, boolean type){
		fullOrder.put(item, r.getMenu().getItemPrice(item));
		calculatePrice(r.getMenu().getItemPrice(item));
		this.setTakeOut(type);
		Random rnd = new Random();
		this.setConfirmationNumber(rnd);
	}


	private void calculatePrice(float itemPrice) {
		this.price += itemPrice;
		
	}
	
	public Random getConfirmationNumber() {
		return confirmationNumber;
	}


	public void setConfirmationNumber(Random confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}


	public boolean isTakeOut() {
		return takeOut;
	}


	public void setTakeOut(boolean takeOut) {
		this.takeOut = takeOut;
	}


	public float getPrice() {
		return price;
	}

	
	
	
	
	
	
	
	
}

