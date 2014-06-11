/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st0kke.rentalreview.restservices.service;

import com.st0kke.rentalreview.restservices.model.Property;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 
 */
@Stateless
public class PropertyFacadeImpl implements PropertyFacade{
    
    @PersistenceContext(unitName="rentals")
    private EntityManager em;
    
    @Override
    public int addProperty() {
        
        Property p = new Property();
        p.setAddress_line1("addr1");
        p.setAddress_line2("addr2");
        p.setAddress_line3("addr3");
        p.setAddress_line4("addr4");
        p.setPropertyType("flat");
        p.setPostcode("post");
        em.persist(p);
        
        return 0;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
