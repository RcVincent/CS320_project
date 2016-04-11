package edu.ycp.cs320.lab03.controller;

import java.util.Random;
import java.util.TreeMap;

public class Order{
	private float price = 0; //starts at zero as an accumulator
	private boolean takeOut;
	private Random random;
	private int orderNumber;
	public TreeMap<String, Float> fullOrder = new TreeMap<String, Float>();
	
	
	public Order(String item, Restaurant r, boolean type){
		fullOrder.put(item, r.getMenu().getItemPrice(item));
		calculatePrice(r.getMenu().getItemPrice(item));
		setTakeOut(type);
		this.random = new Random();
		setorderNumber(this.random.nextInt(100000));
	}


	private void calculatePrice(float itemPrice) {
		this.price += itemPrice;
		
	}
	public boolean getTakeOut() {
		return takeOut;
	}
	
	public void setTakeOut(boolean takeOut) {
		this.takeOut = takeOut;
	}


	public float getPrice() {
		return price;
	}


	public int getorderNumber() {
		return orderNumber;
	}


	public void setorderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}

