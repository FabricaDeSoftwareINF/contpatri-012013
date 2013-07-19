/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.fs.contpatri.web.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emerson
 */
public class HibernateUtilTest {
	
	public HibernateUtilTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of getSessionFactory method, of class HibernateUtil.
	 */
	@Test
	public void testGetSessionFactory() {
		System.out.println("getSessionFactory");
		SessionFactory expResult = null;
		SessionFactory result = HibernateUtil.getSessionFactory();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of beginTransaction method, of class HibernateUtil.
	 */
	@Test
	public void testBeginTransaction() {
		System.out.println("beginTransaction");
		Session expResult = null;
		Session result = HibernateUtil.beginTransaction();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of commitTransaction method, of class HibernateUtil.
	 */
	@Test
	public void testCommitTransaction() {
		System.out.println("commitTransaction");
		HibernateUtil.commitTransaction();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of rollbackTransaction method, of class HibernateUtil.
	 */
	@Test
	public void testRollbackTransaction() {
		System.out.println("rollbackTransaction");
		HibernateUtil.rollbackTransaction();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of closeSession method, of class HibernateUtil.
	 */
	@Test
	public void testCloseSession() {
		System.out.println("closeSession");
		HibernateUtil.closeSession();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getSession method, of class HibernateUtil.
	 */
	@Test
	public void testGetSession() {
		System.out.println("getSession");
		Session expResult = null;
		Session result = HibernateUtil.getSession();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}