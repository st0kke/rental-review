package com.st0kke.rentalreview.restservices.service;

import javax.ejb.Local;

import com.st0kke.rentalreview.restservices.model.Review;

@Local
public interface ReviewService {
	
	Review addNewReview(String addr1, String addr2, String addr3, String addr4, String postcode, int rating, String comment);

	Review addReviewToExistingProperty(long propertyId, int rating, String comment);

}
