package com.st0kke.rentalreview.persistence.model;

import static org.junit.Assert.*;

import javax.persistence.Query;

import org.junit.Test;

import com.st0kke.rentalreview.restservices.model.Property;
import com.st0kke.rentalreview.restservices.model.Review;

public class ReviewTest extends JPAEntityTest {
	
	@Test
	public void addReview() {
		
		Property p = new Property();
		p.setAddress_line1("addr1");
		p.setAddress_line2("addr2");
		p.setAddress_line3("addr3");
		p.setAddress_line4("addr4");
		p.setPropertyType("flat");
		p.setPostcode("post");
		
		Review review1 = new Review();
		review1.setComment("This property is brilliant");
		review1.setRating(5);
		review1.setProperty(p);
		review1.setActiveFlag(true);
		em.persist(review1);
		
		Query q = em.createNamedQuery(Review.FIND_ALL_REVIEWS);
		assertEquals(1, q.getResultList().size());
		
		Review reviewFromDB = (Review) q.getSingleResult();
		assertEquals(review1, reviewFromDB);
		
		assertEquals(p, reviewFromDB.getProperty());
		
	}

}
