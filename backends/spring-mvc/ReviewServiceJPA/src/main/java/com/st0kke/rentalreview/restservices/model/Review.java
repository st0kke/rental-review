package com.st0kke.rentalreview.restservices.model;
/*
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
*/
import com.google.common.base.Objects;


//@Entity
public class Review {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
	*/
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private int rating;
	
	private String comment;
	
	//@Column (name="active")
	private boolean activeFlag;

	@Override
	public int hashCode() {
		return Objects.hashCode(rating, comment, activeFlag);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Review) {
			Review other = (Review) obj;
			return Objects.equal(rating, other.rating) &&
					Objects.equal(comment, other.comment) &&
					Objects.equal(activeFlag, other.activeFlag);
		} else {
			return false;
		}
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/*
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	*/

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		/*return "Review [id=" + id + ", property=" + property + ", rating="
				+ rating + ", comment=" + comment + "]";
				*/
		return Objects.toStringHelper(this).toString();
	}
	
	
	

}
