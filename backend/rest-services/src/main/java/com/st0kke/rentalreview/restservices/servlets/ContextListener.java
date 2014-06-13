/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st0kke.rentalreview.restservices.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author metteaarestrupbyrresen
 */
@WebListener()
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
