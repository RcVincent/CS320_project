package edu.ycp.cs320.lab03.controller;


import java.awt.List;
import java.util.TreeMap;
import java.util.Iterator;


public class Menu {
	private List itemList;
	private TreeMap<String, Float> mapper = new TreeMap<String, Float>();

	private void addToMenu(String item, float price){
		this.mapper.put(item, price);
	}
	
	//for patron to view items for purchase
	public List viewItems(){
		return this.itemList;
	}
	
	
	
	//for restaurant to build a menu
	public void itemToAdd(String s, Float price){
		this.itemList.add(s);
		addToMenu(s, price);
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
