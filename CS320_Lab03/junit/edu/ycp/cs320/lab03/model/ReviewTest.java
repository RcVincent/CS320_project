package edu.ycp.cs320.lab03.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab03.model.Restaurant;
import edu.ycp.cs320.lab03.model.Review;
//import edu.ycp.cs320.lab03.model.User;

public class ReviewTest {
	//private User reviewer;	I thought we had it linked to the user. 
	private Review rev; 
	private Restaurant r; 

	@Before
	public void setUp() throws Exception{
		rev = new Review("You're gonna have a good time", "Good", 3); 
	}

	@Test
	public void getTitleTest(){
		assertEquals("You're gonna have a good time", rev.getTitle());
	}

	@Test
	public void getContentsTest() throws Exception {
		assertEquals("Good", rev.getReview());
	}

	public void getRatingsTest()throws Exception {
		assertEquals(3, rev.getRating());
	}

	public void addReviewToRestaurant() throws Exception {
		r.addReview(rev);
		assertEquals(1, r.reviews.size()); 
	}

	public void viewReview() throws Exception {
		r.reviews.get(0);
	}

}
