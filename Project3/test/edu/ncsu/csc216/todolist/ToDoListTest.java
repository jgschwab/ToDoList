package edu.ncsu.csc216.todolist;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the ToDoList class
 * @author Justin Schwab
 *
 */
public class ToDoListTest {

	/**
	 * Tests the methods of ToDoList
	 */
	@Test
	public void test() {
		ToDoList tdl = new ToDoList();
		assertEquals("Categories", tdl.getCategoryList().getName());
		assertEquals("New List", tdl.getTaskList(0).getName());
		assertEquals("TL1", tdl.getTaskList(0).getTaskListID());
		assertFalse(tdl.isChanged());
		tdl.setChanged(true);
		assertTrue(tdl.isChanged());
		tdl.setChanged(false);
		assertFalse(tdl.isChanged());
		assertNull(tdl.getFilename());
		tdl.setFilename("coolList1.txt");
		assertEquals("coolList1.txt", tdl.getFilename());
		tdl.addTaskList();
		tdl.addTaskList();
		tdl.addTaskList();
		tdl.removeTaskList(0);
		assertEquals("TL2", tdl.getTaskList(0).getTaskListID());
		assertEquals(3, tdl.getNumTaskLists());
		tdl.saveDataFile("test-files/CoolList1.txt");
		tdl.openDataFile("test-files/CoolList1.txt");		
	}
}
