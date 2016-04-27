package edu.ycp.cs320.lab03.controller;

import java.util.Random;
import java.util.TreeMap;

public class Order{
	private Double price;
	private String item;
	private boolean takeOut;
	private Random random;
	private int orderId; //for database access
	private int patronId; //for database access
	private int orderNumber;
	public TreeMap<String, Double> fullOrder = new TreeMap<String, Double>();
	
	
	public Order(/*String item, Restaurant r, boolean type*/){
		//only create a randomized order number when creating a new order
		//will be stored in database
		//fullOrder.put(item, r.getMenu().getItemPrice(item));
		//setTakeOut(type);
		this.random = new Random();
		setorderNumber(this.random.nextInt(100000));
	}

	public boolean getTakeOut() {
		return takeOut;
	}
	
	public void setTakeOut(boolean takeOut) {
		this.takeOut = takeOut;
	}
	

	public int getorderNumber() {
		return orderNumber;
	}


	public void setorderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPatronId() {
		return patronId;
	}

	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}

