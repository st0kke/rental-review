package com.st0kke.rentalreview.persistence.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class JPAEntityTest {

	private static final String PROPERTY_PERSISTENCE_UNIT = "testPU";
	private static EntityManagerFactory emf;
	protected static EntityManager em;

	@BeforeClass
	public static void initTestFixtures() throws Exception {
		emf = Persistence.createEntityManagerFactory(PROPERTY_PERSISTENCE_UNIT);
	}

	@AfterClass
	public static void closeTestFixtures() {
		emf.close();
	}

	@Before
	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	@After
	public void rollbackTransaction() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
	
		if (em.isOpen()) {
			em.close();
		}
	}

	public JPAEntityTest() {
		super();
	}

}