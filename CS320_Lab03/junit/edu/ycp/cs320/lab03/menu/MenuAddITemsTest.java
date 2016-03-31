package edu.ycp.cs320.lab03.menu;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.controller.Menu;

public class MenuAddITemsTest {
	private Menu menu; 
	private String item1;
	private String item2;
	private String item3;
	private float price1;
	private float price2;
	private float price3;
	
	@Before
	public void  setUp() throws Exception {
		menu = new Menu(); 
		price1 = (float) 10.99;
		price2 = (float) 4.50;
		price3 = (float) 7.50;		
	}
	
	
	@Test
	public void addItemTest() throws Exception {
		menu.itemToAdd(item1, price1);
		menu.itemToAdd(item2, price2);
		menu.itemToAdd(item3, price3);
		
		assertEquals(menu.getMenuSize(), 3);
	}
	
	@Test
	public void testViewPrices() throws Exception {
		
	}
	
	@Test
	public void testViewMenu() throws Exception {
		menu.viewItems();
	}
}
