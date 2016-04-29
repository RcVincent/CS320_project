package edu.ycp.cs320.lab03.model;


import java.awt.List;
import java.util.TreeMap;


public class Menu {
	private List itemList;
	private String item;
	private int menuId;   //for database
	private int restId;   //for database
	private Double price;
	private TreeMap<String, Double> mapper = new TreeMap<String, Double>();

	public void addToMenu(String item, Double price){
		this.mapper.put(item, price);
		
	}
	//How the consumer sees what items there are
	public void additemsToList(String s) {
		itemList.add(s);
	}
	
	//for patron to view items for purchase
	public List viewItems(){
		return this.itemList;
	}
		
	//for patron
	public Double getItemPrice(String s){
		return this.mapper.get(s);
	}
	
	//for restaurant use
	public int getMenuSize(){
		return mapper.size();
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
		
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public void setMenuId(Integer integer) {
		this.menuId = integer;	
	}
	public Integer getMenuId() {
		return this.menuId;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}

	
}
