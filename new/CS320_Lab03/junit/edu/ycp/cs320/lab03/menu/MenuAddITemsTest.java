package edu.ycp.cs320.lab03.menu;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Menu;
import edu.ycp.cs320.lab03.controller.Restaurant;

public class MenuAddITemsTest {
	private Menu menu; 
	
	private Float price1;
	private Float price2;
	private Float price3;
	
	@Before
	public void  setUp() throws Exception {
		//set up test item names
		menu = new Menu();
		
		
		//set up test item prices
		price1 =  (float) 10.99;
		price2 = (float) 4.50;
		price3 = (float) 7.50;	
		
		menu.addToMenu("hamburger", price1);
		menu.addToMenu("hotdog", price2);
		menu.addToMenu("pizza", price3);
		
	}
	
	
	@Test
	public void TestMenuSize() throws Exception {
		assertEquals(3, menu.getMenuSize());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testViewPrices() throws Exception {
		assertEquals(10.99 , menu.getItemPrice("hamburger"), 0.000001);
		assertEquals(4.50, menu.getItemPrice("hotdog"), 0.000001);
		assertEquals(7.50, menu.getItemPrice("pizza"), 0.000001);
	}
	
	
	@Test
	public void testViewMenu() throws Exception {
		menu.viewItems();
	}
	
}
