package com.st0kke.rentalreview.restservices.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name=Review.FIND_ALL_REVIEWS, query="SELECT r FROM Review r"),
        @NamedQuery(name=Review.FIND_BY_REVIEW_ID, query="SELECT r FROM Review r WHERE r.id = :id")
	})
public class Review {
	
	public static final String FIND_ALL_REVIEWS = "findAllReviews";
        public static final String FIND_BY_REVIEW_ID = "findByReviewId";
	
	@SequenceGenerator(name="review_gen", sequenceName="review_seq", allocationSize=1)
	@Id
	@GeneratedValue(generator="review_gen")
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
	
	private int rating;
	
	private String comment;
	
	@Column (name="active")
	private boolean activeFlag;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activeFlag ? 1231 : 1237);
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
		result = prime * result + rating;
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
		Review other = (Review) obj;
		if (activeFlag != other.activeFlag)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

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
		return "Review [id=" + id + ", property=" + property + ", rating="
				+ rating + ", comment=" + comment + "]";
	}
	
	
	

}
