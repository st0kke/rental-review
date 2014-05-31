package com.st0kke.rentalreview.restservices.service;

import com.st0kke.rentalreview.restservices.model.Property;
import com.st0kke.rentalreview.restservices.model.Review;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReviewServiceImpl implements ReviewService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Review addNewReview(String addr1, String addr2, String addr3,
			String addr4, String postcode, int rating, String comment) {
		
		Property property = new Property();
		property.setAddress_line1(addr1);
		property.setAddress_line2(addr2);
		property.setAddress_line3(addr3);
		property.setAddress_line4(addr4);
		property.setPostcode(postcode);
		
		Review review = new Review();
		review.setProperty(property);
		review.setComment(comment);
		review.setRating(rating);
		review.setActiveFlag(true);
		
		em.persist(review);
		
		return review;
	}


	@Override
	public Review addReviewToExistingProperty(long propertyId, int rating,
			String comment) {
		
		Property property = em.find(Property.class, propertyId);
		
		Review review = new Review();
		review.setProperty(property);
		review.setComment(comment);
		review.setRating(rating);
		review.setActiveFlag(true);	
	
		em.persist(review);
		
		return review;
		
	}

}
