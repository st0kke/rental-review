/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st0kke.rentalreview.restservices.service;

import com.st0kke.rentalreview.restservices.ejb.ReviewFacade;
import com.st0kke.rentalreview.restservices.model.Review;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
@RequestScoped
public class ReviewService {
    
    @Inject 
    private ReviewFacade reviewFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReview(Review review) {
        System.out.println("Called with review" + review);
               
        return Response.ok(review).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReviews() {
        try {
            List<Review> reviews = reviewFacade.getAllReviews();
            Review[] reviewArray = reviews.toArray(new Review[reviews.size()]);
            return Response.ok(reviewArray).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReview(@PathParam("id") long reviewId){
        Review review = reviewFacade.getReview(reviewId);
        return Response.ok(review).build();
    }
    
}
