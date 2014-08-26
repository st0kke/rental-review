package com.st0kke.rentalreview.restservices.api.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.st0kke.rentalreview.restservices.controller.ReviewController;
import com.st0kke.rentalreview.restservices.model.Review;

public class ReviewControllerTest {

	private ReviewController reviewService = new ReviewController();
	
	@Test
	public void testAddReview() {
		Review r = new Review();
		r.setActiveFlag(true);
		r.setComment("These are my comments");
		r.setRating(5);
		boolean b = reviewService.addReview(r);
		
		assertEquals(true, b);
		
		List<Review> allReviews = reviewService.getReviews();
		assertFalse(allReviews.isEmpty());
		assertTrue(allReviews.contains(r));
		
	}
}
