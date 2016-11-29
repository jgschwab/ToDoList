package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * Tests the TaskList class
 * @author Justin Schwab
 *
 */
public class TaskListTest {

	/**
	 * Tests the TaskList methods
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Category c = new Category("a1", "alpha", "Number One");
		TaskList tlist = new TaskList("My Tasks", "TL1");
		assertEquals("My Tasks", tlist.getName());
		assertEquals("TL1", tlist.getTaskListID());
		assertEquals(0, tlist.size());
		try{
			tlist.removeTaskAt(0);
		} catch(IndexOutOfBoundsException e){
			assertEquals(0, tlist.size());
		} 
		
		assertTrue(tlist.isEmpty());
		assertTrue(tlist.addTask("Finish this test class", "just keep writing tests...", new Date(2016, 11, 1), new Date(2016, 11, 16), c));
		assertFalse(tlist.isEmpty());
		assertEquals(1, tlist.size());
		assertEquals("Finish this test class", tlist.getTaskAt(0).getTitle());
		assertEquals("just keep writing tests...", tlist.getTaskAt(0).getDetails());
		assertEquals(c, tlist.getTaskAt(0).getCategory());
		assertEquals("TL1-T1", tlist.getTaskAt(0).getTaskID());
		assertEquals("TL1-T1", tlist.get2DArray()[0][0]);
		assertEquals("Finish this test class", tlist.get2DArray()[0][1]);
		assertEquals("Finish this test class", tlist.get2DArray()[0][1]);
		assertEquals(0, tlist.indexOf("TL1-T1"));
		
		assertTrue(tlist.addTask("Finish this test class", "just keep writing tests...", new Date(2016, 11, 3), new Date(2016, 11, 30), c));
		assertEquals("TL1-T1", tlist.removeTaskAt(0).getTaskID());
		assertTrue(tlist.removeTask("TL1-T2"));
	}

}
