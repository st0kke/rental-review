package com.st0kke.rentalreview.restservices.api;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

import com.st0kke.rentalreview.restservices.model.Review;

public interface ReviewServiceAPI {

	public static final String REVIEW_SERVICE = "/review";
	
	@GET(REVIEW_SERVICE)
	public List<Review> getReviews();
	
	@POST(REVIEW_SERVICE)
	public boolean addReview(@Body Review r);
	
}
