package com.st0kke.rentalreview.restservices.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st0kke.rentalreview.restservices.api.ReviewServiceAPI;
import com.st0kke.rentalreview.restservices.model.Review;

@Controller
//@RequestMapping(value=ReviewServiceAPI.REVIEW_SERVICE)
public class ReviewController implements ReviewServiceAPI {

	private List<Review> allReviews = new CopyOnWriteArrayList<Review>(); 
	
	private static Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Override
	@RequestMapping(value=ReviewServiceAPI.REVIEW_SERVICE, method=RequestMethod.GET)
	public @ResponseBody List<Review> getReviews() {
		//TODO: figure out how to use logging in Gradle
		logger.debug("getting reviews");
		return allReviews;
	}

	@Override
	@RequestMapping(value=ReviewServiceAPI.REVIEW_SERVICE, method=RequestMethod.POST)
	public @ResponseBody boolean addReview(@RequestBody Review r) {
		logger.debug("adding review: " + r);
		return allReviews.add(r);
	}

}
