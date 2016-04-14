package edu.ycp.cs320.lab03.controller;

public class Review {
	private String review;
	private String title;
	private int rating;
	
	public Review(String title, String rev, int rate){
		this.setTitle(title);
		this.setRating(rate);
		this.setReview(rev);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
}
