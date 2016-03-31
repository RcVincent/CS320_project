package edu.ycp.cs320.lab03.controller;


import java.awt.List;
import java.util.TreeMap;
import java.util.Iterator;


public class Menu {
	private List itemList;
	private TreeMap<String, Float> mapper = new TreeMap<String, Float>();

	public void addToMenu(String item, float price){
		this.mapper.put(item, price);
		itemList.add(item);
	}
	
	//for patron to view items for purchase
	public List viewItems(){
		return this.itemList;
	}
		
	//for patron
	public float getItemPrice(String s){
		return this.mapper.get(s);
	}
	
	//for restaurant use
	public int getMenuSize(){
		return mapper.size();
	}
	
}
