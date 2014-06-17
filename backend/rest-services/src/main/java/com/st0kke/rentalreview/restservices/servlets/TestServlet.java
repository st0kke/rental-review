/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st0kke.rentalreview.restservices.servlets;

import com.st0kke.rentalreview.restservices.model.Review;
import com.st0kke.rentalreview.restservices.ejb.ReviewFacade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 * 
 */
//TODO: remove this class
@WebServlet(name= "TestServlet", urlPatterns = {"/TestServlet", "/TestServlet/reviews/new"})
public class TestServlet extends HttpServlet {
    
    @EJB
    private ReviewFacade reviewFacade;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        List<Review> newReviews = this.addSomeReviews();
         
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            
            
            for (Review r : newReviews) {
                out.println("<p>");
                out.println("added the review: " + r);
                out.println("</p>");
            }
            
            out.println("<h1>A Specific Review </h1>");
            out.println(this.reviewFacade.getReview(7));
            
            out.println("<h1> All Reviews </h1>");
            
            List<Review> allReviews = reviewFacade.getAllReviews();
            for (Review r : allReviews) {
                out.println("<p>");
                out.println("review: " + r);
                out.println("</p>");
            }
            
            
            
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    private List<Review> addSomeReviews() {
        Review r = reviewFacade.addNewReview("addr1", "addr2", "addr3", "addr4", "postcode", 1, "comment");
        Review r2 = reviewFacade.addReviewToExistingProperty(r.getProperty().getId(), 5, "another comment");
      
        List<Review> newReviews = new ArrayList<Review>();
        newReviews.add(r);
        newReviews.add(r2);
                
        return newReviews;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("TestServlet called");
        out.println("Request Parameters: " + getRequestParameters(request));
        out.println("Request Headers: " + getRequestHeaders(request));
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getRequestParameters(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String nextElement = (String) e.nextElement();
            builder.append(nextElement + " -> " + request.getParameter(nextElement));
        }
        return builder.toString();
    }

    private String getRequestHeaders(HttpServletRequest request) {
       StringBuilder builder = new StringBuilder();
       for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
           String nextElement = (String) e.nextElement();
           builder.append(nextElement + " -> " + request.getHeader(nextElement));
       }
       
       return builder.toString();
    }

}
