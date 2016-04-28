package edu.ycp.cs320.lab03.model;

import java.util.ArrayList;

public class Search {

	Restaurant rest1 = new Restaurant(/*"YCP restaurant", new Address(123, "york street", "York", "PA", 12345)*/);
	Restaurant rest2 = new Restaurant(/*"Austin's pizza", new Address(456, "rodeo drive", "Boston", "TX", 12356)*/);
	Restaurant rest3 = new Restaurant(/*"Wag's ribs", new Address(151, "bark court", "Boston", "TX", 45645)*/);
	ArrayList<Restaurant> restList = new ArrayList<Restaurant>();


	public Search(){
		this.rest1.setName("YCP restaurant");
		this.rest1.setAddress("123 york street York PA 12345");
		this.rest2.setName("Autins Pizza");
		this.rest2.setAddress("456 rodeo drive Boston TX, 12356");
		this.rest3.setName("Wags Ribs");
		this.rest3.setAddress("151 Bark court Boston TX 45656");
		restList.add(rest1);
		restList.add(rest2);
		restList.add(rest3);
		
	}

	public ArrayList<Restaurant> searchRestaurantsByName(String name){
	

		ArrayList<Restaurant> resultList = new ArrayList<Restaurant>();
		for (int i = 0; i < restList.size(); i++){
			if(restList.get(i).getName().equals(name)){
				resultList.add(restList.get(i));
			}
		}

		return resultList;

	}
//	public ArrayList<Restaurant> searchRestaurantsByCity(String city){
//
//		ArrayList<Restaurant> resultList = new ArrayList<Restaurant>();
//		for (int i = 0; i < restList.size(); i++){
//			if(restList.get(i).getAddress().getCity().equals(city)){
//				resultList.add(restList.get(i));
//			}
//		}
//		return resultList;
//	}
}
