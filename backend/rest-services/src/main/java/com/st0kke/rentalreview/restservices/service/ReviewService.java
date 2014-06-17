/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st0kke.rentalreview.restservices.service;

import com.st0kke.rentalreview.restservices.ejb.ReviewFacade;
import com.st0kke.rentalreview.restservices.ejb.ReviewFacadeImpl;
import com.st0kke.rentalreview.restservices.model.Review;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("reviews")
public class ReviewService {
    
    @EJB 
    private ReviewFacade reviewManager;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addReview(Review review) {
        System.out.println("add called");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReviews() {
        Review r1 = new Review();
        r1.setComment("a comment");
        r1.setRating(1);
        
        Review r2 = new Review();
        r2.setComment("a comment");
        r2.setRating(1);
        
        List<Review> allReviews = new ArrayList<Review>();
        allReviews.add(r1);
        allReviews.add(r2);
        /*
        Review review = reviewManager.getReview(reviewId);
        return review;
        */
        return Response.ok().entity(r1).entity(r2).build();
        
        //return reviewManager.getAllReviews();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReview(@PathParam("id") long reviewId){
        System.out.println("Called with " + reviewId);
        Review review = new Review();
        review.setComment("a comment");
        review.setRating(1);
        /*
        Review review = reviewManager.getReview(reviewId);
        return review;
        */
        return Response.ok(review).build();
        //return "hello world " + reviewManager;
    }
    
}
