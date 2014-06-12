package com.st0kke.rentalreview.restservices.service;

import com.st0kke.rentalreview.restservices.model.Property;
import com.st0kke.rentalreview.restservices.model.Review;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Path;

@Stateless
@Path("/reviews")
public class ReviewFacadeImpl implements ReviewFacade {
	
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

    @Override
    public Review getReview(long reviewId) {
        TypedQuery<Review> query = em.createNamedQuery(Review.FIND_BY_REVIEW_ID, Review.class).setParameter("id", reviewId);
        Review review = query.getSingleResult();
        return review;
    }

    @Override
    public List<Review> getAllReviews() {
        TypedQuery<Review> query = em.createNamedQuery(Review.FIND_ALL_REVIEWS, Review.class);
        List<Review> results = query.getResultList();
        
        return results;
        
    }

}
