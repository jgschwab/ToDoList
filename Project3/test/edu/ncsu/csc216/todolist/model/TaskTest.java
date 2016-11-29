package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * Tests the Task class
 * @author Justin Schwab
 *
 */
public class TaskTest {

	/**
	 * Tests the Task constructor, and setters by extension
	 */
	@Test
	public void testTask() {
		Category c1 = new Category("a1", "alpha", "Number One");
		Task t2 = new Task("Take out the trash", "", new Date(), new Date(), c1 , "T2");
		t2 = new Task("Take out the trash", null, new Date(), new Date(), c1 , "T2");
		t2 = new Task("Take out the trash", null, new Date(), new Date(), c1 , "T2");
		
		try{
			t2 = new Task("", null, new Date(), new Date(), c1 , "");
		} catch(IllegalArgumentException e){
			//PASS
		}
		
		try{
			t2 = new Task("Take out the trash", null, null, new Date(), c1 , "T2");
		} catch(IllegalArgumentException e){
			//PASS
		}
		
		try{
			t2 = new Task("Take out the trash", null, new Date(), null, c1 , "T2");
		} catch(IllegalArgumentException e){
			//PASS
		}
		
		try{
			t2 = new Task("Take out the trash", null, new Date(), new Date(), null , "T2");
		} catch(IllegalArgumentException e){
			//PASS
		}
		
		try{
			t2 = new Task("Take out the trash", null, new Date(), new Date(), c1 , "");
		} catch(IllegalArgumentException e){
			//PASS
		}
		
		try{
			t2 = new Task("Take out the trash", null, new Date(), new Date(), c1 , null);
		} catch(IllegalArgumentException e){
			//PASS
		}
		
		Task t1 = new Task("Do the dishes", "clean those dishes, fuccboi", new Date(), new Date(), c1 , "T1");
		t1.setCompleted(true);
		t1.setCompletedDateTime(new Date());
		assertTrue(t1.isCompleted());
		assertTrue(t1.getCompletedDateTime() != null);
		assertEquals("Do the dishes", t1.getTitle());
		assertEquals("clean those dishes, fuccboi", t1.getDetails());
		assertEquals(c1, t1.getCategory());
		assertFalse(t1.getStartDateTime() == null);
		assertFalse(t1.getDueDateTime() == null);
		assertEquals("T1", t1.getTaskID());
		assertEquals(0, t1.compareTo(t1));
		assertEquals(t1.hashCode(), t1.hashCode());
		assertFalse(t1.hashCode() == t2.hashCode());
		//assertFalse(t1.equals(null)); Useful for testing, but PMD gave me crap about it
	}

}
