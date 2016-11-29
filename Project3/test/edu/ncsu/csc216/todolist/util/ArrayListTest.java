package edu.ncsu.csc216.todolist.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.todolist.model.Category;

/**
 * Tests the custom ArrayList for ToDoList
 * @author Justin Schwab
 *
 */
public class ArrayListTest {

	/**
	 * tests the ArrayList constructor
	 */
	@Test
	public void testArrayList() {
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		
		ArrayList list2 = new ArrayList(5);
		assertEquals(0, list2.size());
	}
	
	/**
	 * tests the addIdx() method
	 */
	@Test
	public void testAddIdx() {
		ArrayList list = new ArrayList();
		Object o = new Category("General", "general things I need to do", "C1");
		assertEquals(0, list.size());
		try{
			list.add(-1, o);
			fail("Can't add at index -1");
		} catch(IndexOutOfBoundsException e){
			assertEquals(0, list.size());
		} 
		try{
			list.add(1, o);
			fail("Can't add at index larger than size");
		} catch(IndexOutOfBoundsException e){
			assertEquals(0, list.size());
		}
		
		try{
			list.add(0, null);
		} catch(NullPointerException e){
			assertEquals(0, list.size());
		}
		
		list.add(0, o); //add to empty
		assertEquals(1, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		
		//Try to add duplicate
		try{
			list.add(1, o);
			fail("Can't add duplicates");
		} catch(IllegalArgumentException e){
			assertEquals(1, list.size());
			assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		}
		
		Object o2 = new Category("Specific", "Specific things I need to do", "C2");
		list.add(1, o2); //add to end
		assertEquals(2, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		assertEquals(new Category("Specific", "Specific things I need to do", "C2"), list.get(1));
		
		
		Object o3 = new Category("CSC216", "java stuff", "C3");
		list.add(1, o3); //add at middle
		assertEquals(3, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		assertEquals(new Category("CSC216", "java stuff", "C3"), list.get(1));
		assertEquals(new Category("Specific", "Specific things I need to do", "C2"), list.get(2));
		
		
		Object o4 = new Category("Personal", "personal to-dos", "C4");
		list.add(0, o4); //add at the front
		assertEquals(4, list.size()); 
		assertEquals(new Category("Personal", "personal to-dos", "C4"), list.get(0));
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(1));
		assertEquals(new Category("CSC216", "java stuff", "C3"), list.get(2));
		assertEquals(new Category("Specific", "Specific things I need to do", "C2"), list.get(3));
	}
	
	/**
	 * tests the add() method
	 */
	@Test
	public void testAdd() {
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		Object o = new Category("General", "general things I need to do", "C1");
		try{
			list.add(null);
		} catch(NullPointerException e){
			assertEquals(0, list.size());
		}
		
		list.add(o); //add to empty
		assertEquals(1, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		
		assertFalse("Can't add duplicates", list.add(o));
		
		Object o2 = new Category("Specific", "Specific things I need to do", "C2");
		list.add(o2);
		assertEquals(2, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		assertEquals(new Category("Specific", "Specific things I need to do", "C2"), list.get(1));
	}
	
	/**
	 * tests the contains() method
	 */
	@Test
	public void testContains(){
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		
		Object o = new Category("General", "general things I need to do", "C1");
		list.add(o);
		Object o2 = new Category("Specific", "Specific things I need to do", "C2");
		list.add(o2);
		
		assertTrue(list.contains(o2));
		assertTrue(list.contains(o));
	}
	
	/**
	 * tests ArrayList's get() method
	 */
	@Test
	public void testGet(){
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		
		Object o = new Category("General", "general things I need to do", "C1");
		list.add(o);
		Object o2 = new Category("Specific", "Specific things I need to do", "C2");
		list.add(o2);
		
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
	}
	
	/**
	 * tests the ArrayList's indexOf() method
	 */
	@Test
	public void testIndexOf(){
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		
		Object o = new Category("General", "general things I need to do", "C1");
		list.add(o);
		Object o2 = new Category("Specific", "Specific things I need to do", "C2");
		list.add(o2);
		
		assertEquals(0, list.indexOf(o));
		assertEquals(1, list.indexOf(o2));
	}
	
	/**
	 * tests the ArrayList's isEmpty() method
	 */
	@Test
	public void testIsEmpty(){
		ArrayList list = new ArrayList();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.add(new Category("General", "general things I need to do", "C1"));
		assertFalse(list.isEmpty());
		list.remove(0);
		assertTrue(list.isEmpty());
	}
	
	/**
	 * tests ArrayList's remove() method
	 */
	@Test
	public void testRemove(){
		ArrayList list = new ArrayList(3);
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.add(new Category("General", "general things I need to do", "C1"));
		list.add(new Category("Specific", "specific things I need to do", "C2"));
		list.add(new Category("CSC216", "things I need to do for java", "C3"));
		list.add(new Category("PERSONAL", "personal things I need to do", "C4"));
		assertEquals(4, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		assertEquals(new Category("Specific", "specific things I need to do", "C2"), list.get(1));
		assertEquals(new Category("CSC216", "things I need to do for java", "C3"), list.get(2));
		assertEquals(new Category("PERSONAL", "personal things I need to do", "C4"), list.get(3));
		list.remove(3);
		assertEquals(3, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		assertEquals(new Category("Specific", "specific things I need to do", "C2"), list.get(1));
		assertEquals(new Category("CSC216", "things I need to do for java", "C3"), list.get(2));
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals(new Category("General", "general things I need to do", "C1"), list.get(0));
		assertEquals(new Category("CSC216", "things I need to do for java", "C3"), list.get(1));
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals(new Category("CSC216", "things I need to do for java", "C3"), list.get(0));
		list.remove(0);
		assertEquals(0, list.size());
	}
}
