package edu.ycp.cs320.lab03.controller;

import java.util.TreeMap;

public class Menu {
	private float price;
	private TreeMap<String, Float> mapper = new TreeMap<String, Float>();
	
	public void addToMenu(String item, float price){
		this.mapper.put(item, price);
	}
	
	 public float getItemPrice(String s){
		 this.price = this.mapper.get(s);
		 return this.price;
	 }
}
