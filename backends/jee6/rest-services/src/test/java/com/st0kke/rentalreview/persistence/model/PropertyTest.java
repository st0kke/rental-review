package com.st0kke.rentalreview.persistence.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.Query;
import org.junit.Test;

import com.st0kke.rentalreview.restservices.model.Property;

public class PropertyTest extends JPAEntityTest {

	@Test
	public void addProperty() {
		Property p = new Property();
		p.setAddress_line1("addr1");
		p.setAddress_line2("addr2");
		p.setAddress_line3("addr3");
		p.setAddress_line4("addr4");
		p.setPropertyType("flat");
		p.setPostcode("post");
		em.persist(p);

		Query query = em.createNamedQuery(Property.FIND_ALL_PROPERTIES);
		assertEquals(1, query.getResultList().size());

		Property propertyFromDB = (Property) query.getSingleResult();
		assertNotNull(propertyFromDB);

		/*
		assertEquals("addr1", propertyFromDB.getAddress_line1());
		assertEquals("addr2", propertyFromDB.getAddress_line2());
		assertEquals("addr3", propertyFromDB.getAddress_line3());
		assertEquals("addr4", propertyFromDB.getAddress_line4());
		assertEquals("flat", propertyFromDB.getPropertyType());
		assertEquals("post", propertyFromDB.getPostcode());
		*/
		assertEquals(p, propertyFromDB);

	}

}
