package com.st0kke.rentalreview.restservices.api.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

import com.st0kke.rentalreview.restservices.api.ReviewServiceAPI;
import com.st0kke.rentalreview.restservices.model.Review;

public class ReviewServiceAPITest {

	
	private final String END_POINT = "http://localhost:8080";
	
	private ReviewServiceAPI reviewService = new RestAdapter.Builder()
			.setEndpoint(END_POINT)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(ReviewServiceAPI.class);
	
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
	
	
	@Test
	public void testGetAllReview() {
		List<Review> allReviews = reviewService.getReviews();
	}
}

