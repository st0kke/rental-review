/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st0kke.rentalreview.restservices.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 
 */
@Entity
public class Property {
    
    @SequenceGenerator(name="property_gen", sequenceName="property_seq", allocationSize=1)
    @Id @GeneratedValue(generator="property_gen")
    private long id;
    
    private String address_line1;
    private String address_line2;
    private String address_line3;
    private String address_line4;
    private String postcode;
    
    @Column(name="property_type")
    private String propertyType;

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
    
    /*
    @Column(name="date_created", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    */
    
    private boolean active;
    
    /*
    @PrePersist
    protected void onCreate() {
        dateCreated = new Date(System.currentTimeMillis());
    }
*/
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getAddress_line3() {
        return address_line3;
    }

    public void setAddress_line3(String address_line3) {
        this.address_line3 = address_line3;
    }

    public String getAddress_line4() {
        return address_line4;
    }

    public void setAddress_line4(String address_line4) {
        this.address_line4 = address_line4;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /*
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    */

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
    
}
