/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st0kke.rentalreview.restservices.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author 
 */
@Entity
@NamedQueries({
	@NamedQuery(name=Property.FIND_ALL_PROPERTIES, query="SELECT p FROM Property p") }
)
public class Property {
    
	@Override
	public String toString() {
		return "Property [id=" + id + ", address_line1=" + address_line1
				+ ", address_line2=" + address_line2 + ", address_line3="
				+ address_line3 + ", address_line4=" + address_line4
				+ ", postcode=" + postcode + ", propertyType=" + propertyType
				+ ", active=" + active + "]";
	}

	public static final String FIND_ALL_PROPERTIES = "findAllProperties";
	
    @SequenceGenerator(name="property_gen", sequenceName="property_seq", allocationSize=1)
    @Id @GeneratedValue(generator="property_gen")
    private long id;
    
    private String address_line1;
    private String address_line2;
    private String address_line3;
    private String address_line4;
    private String postcode;
    
    @OneToMany(mappedBy="property", cascade=CascadeType.ALL)
    private List<Review> reviews;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((address_line1 == null) ? 0 : address_line1.hashCode());
		result = prime * result
				+ ((address_line2 == null) ? 0 : address_line2.hashCode());
		result = prime * result
				+ ((address_line3 == null) ? 0 : address_line3.hashCode());
		result = prime * result
				+ ((address_line4 == null) ? 0 : address_line4.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result
				+ ((propertyType == null) ? 0 : propertyType.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (active != other.active)
			return false;
		if (address_line1 == null) {
			if (other.address_line1 != null)
				return false;
		} else if (!address_line1.equals(other.address_line1))
			return false;
		if (address_line2 == null) {
			if (other.address_line2 != null)
				return false;
		} else if (!address_line2.equals(other.address_line2))
			return false;
		if (address_line3 == null) {
			if (other.address_line3 != null)
				return false;
		} else if (!address_line3.equals(other.address_line3))
			return false;
		if (address_line4 == null) {
			if (other.address_line4 != null)
				return false;
		} else if (!address_line4.equals(other.address_line4))
			return false;
		if (id != other.id)
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (propertyType == null) {
			if (other.propertyType != null)
				return false;
		} else if (!propertyType.equals(other.propertyType))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}

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
