package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Category class
 * @author Justin Schwab
 * @author Zach Scott
 */
public class CategoryTest {

	/**
	 * Tests Category class functions
	 */
	@Test
	public void test() {
		//Invalid constructions
		Category alpha = null;
		try{
			alpha = new Category("", "alpha", "Number One");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Category ID", e.getMessage());
			assertEquals(null, alpha);
		}
		try{
			alpha = new Category(null, "alpha", "Number One");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Category ID", e.getMessage());
			assertEquals(null, alpha);
		}
		try{
			alpha = new Category("a1", "", "Number One");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Category Name", e.getMessage());
			assertEquals(null, alpha);
		}
		try{
			alpha = new Category("a1", null, "Number One");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Category Name", e.getMessage());
			assertEquals(null, alpha);
		}
		try{
			alpha = new Category("a1", "alpha", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Category Description", e.getMessage());
			assertEquals(null, alpha);
		}
		try{
			alpha = new Category("a1", "alpha", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Category Description", e.getMessage());
			assertEquals(null, alpha);
		}
		
		
		//Valid construction
		alpha = new Category("a1", "alpha", "Number One");
		assertEquals("a1", alpha.getCategoryID());
		assertEquals("alpha", alpha.getName());
		assertEquals("Number One", alpha.getDescription());
		assertTrue(alpha.equals(alpha));
		//assertFalse(alpha.equals(null)); //Useful for testing, but PMD is giving me crap about it
		String s1 = new String("not Alpha");
		assertFalse(alpha.equals(s1));
		
		// tests non-equal comparisons
		Category beta = new Category("b1", "beta", "Number Two");
		assertFalse(alpha.equals(beta));
		assertFalse(alpha.hashCode() == beta.hashCode());
		assertTrue(beta.compareTo(alpha) > 0);
		assertFalse(beta.compareTo(alpha) <= 0);
		assertTrue(alpha.compareTo(beta) < 0);
		
		//tests comparison with categories with the same id
		Category alphaish = new Category("a1", "not quite alpha", "Number One, I guess?");
		assertTrue(alphaish.equals(alpha));
		assertTrue(alpha.hashCode() == alphaish.hashCode());
		assertEquals(alphaish.compareTo(alpha), 0);
		assertEquals(alpha.compareTo(alphaish), 0);
		
		s1 = alpha.toString();
		assertEquals("alpha", s1);
	}

}
