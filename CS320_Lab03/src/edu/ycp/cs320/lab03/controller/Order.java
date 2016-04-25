package edu.ycp.cs320.lab03.controller;

import java.util.Random;
import java.util.TreeMap;

public class Order{
	private Double price = 0.00; //starts at zero as an accumulator
	private boolean takeOut;
	private Random random;
	private int orderNumber;
	public TreeMap<String, Double> fullOrder = new TreeMap<String, Double>();
	
	
	public Order(String item, Restaurant r, boolean type){
		fullOrder.put(item, r.getMenu().getItemPrice(item));
		calculatePrice(r.getMenu().getItemPrice(item));
		setTakeOut(type);
		this.random = new Random();
		setorderNumber(this.random.nextInt(100000));
	}


	private void calculatePrice(Double itemPrice) {
		this.price += itemPrice;
		
	}
	public boolean getTakeOut() {
		return takeOut;
	}
	
	public void setTakeOut(boolean takeOut) {
		this.takeOut = takeOut;
	}


	public Double getPrice() {
		return price;
	}


	public int getorderNumber() {
		return orderNumber;
	}


	public void setorderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}

