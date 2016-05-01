package edu.ycp.cs320.lab03.model;

import java.util.Random;
import java.util.TreeMap;

public class Order{
	private Double price;
	private String item;
	private boolean takeOut;
	private Random random;
	private int orderId; //for database accesses
	private int patronId; //for database accesses
	private String rest;   //for database accesses
	private int quantity;  //number of items to order
	private int orderNumber;
	private String status;
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
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
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

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}

