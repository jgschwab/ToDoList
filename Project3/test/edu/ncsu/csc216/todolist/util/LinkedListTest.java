package edu.ncsu.csc216.todolist.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import edu.ncsu.csc216.todolist.model.Category;
import edu.ncsu.csc216.todolist.model.Task;

/**
 * Tests the custom LinkedList for ToDoList
 * @author Justin Schwab
 *
 */
public class LinkedListTest {

	private Category c1 = new Category("General", "general things I need to do", "C1");
	
	/**
	 * tests the LinkedList constructor
	 */
	@Test
	public void testLinkedList() {
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
	}
	
	/**
	 * tests the addIdx() method
	 */
	@Test
	public void testAddIdx() {
		LinkedList list = new LinkedList();
		Object o = new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1");
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
		
		
		Object o2 = new Category("General", "general things I need to do", "C1");
		try{
			list.add(0, o2);
			fail("Shouldn't be able to add Category objects, only Tasks");
		} catch(IllegalArgumentException e){
			assertEquals(0, list.size());
		}
		
		list.add(0, o); //add to empty
		assertEquals(1, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		
		//Try to add duplicate
		try{
			list.add(1, o);
			fail("Can't add duplicates");
		} catch(IllegalArgumentException e){
			assertEquals(1, list.size());
			assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		}
		
		o2 = new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2");
		list.add(1, o2); //add to end
		assertEquals(2, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		assertEquals(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"), list.get(1));
		
		
		Object o3 = new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3");
		list.add(1, o3); //add at middle
		assertEquals(3, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		assertEquals(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"), list.get(1));
		assertEquals(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"), list.get(2));
		
		
		Object o4 = new Task("Eat", "Eat lots of food", new Date(), new Date(), c1, "T4");
		list.add(0, o4); //add at the front
		assertEquals(4, list.size()); 
		assertEquals(new Task("Eat", "Eat lots of food", new Date(), new Date(), c1, "T4"), list.get(0));
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(1));
		assertEquals(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"), list.get(2));
		assertEquals(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"), list.get(3));
	}
	
	/**
	 * tests the add() method
	 */
	@Test
	public void testAdd() {
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
		Object o = new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1");
		try{
			list.add(null);
		} catch(NullPointerException e){
			assertEquals(0, list.size());
		}
		
		list.add(o); //add to empty
		assertEquals(1, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		
		assertFalse("Can't add duplicates", list.add(o));
		
		
		Object o2 = new Category("General", "general things I need to do", "C1");

		assertFalse("Can't add Tasks, only Categories", list.add(o2));
		
		o2 = new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2");
		list.add(o2);
		assertEquals(2, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		assertEquals(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"), list.get(1));
	}
	
	/**
	 * tests the contains() method
	 */
	@Test
	public void testContains(){
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
		
		Object o = new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1");
		list.add(o);
		Object o2 = new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2");
		list.add(o2);
		
		assertTrue(list.contains(o2));
		assertTrue(list.contains(o));
	}
	
	/**
	 * tests LinkedList's get() method
	 */
	@Test
	public void testGet(){
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
		
		Object o = new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1");
		list.add(o);
		Object o2 = new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2");
		list.add(o2);
		
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
	}
	
	/**
	 * tests the LinkedList's indexOf() method
	 */
	@Test
	public void testIndexOf(){
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
		
		Object o = new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1");
		list.add(o);
		Object o2 = new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2");
		list.add(o2);
		
		assertEquals(0, list.indexOf(o));
		assertEquals(1, list.indexOf(o2));
	}
	
	/**
	 * tests the LinkedList's isEmpty() method
	 */
	@Test
	public void testIsEmpty(){
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.add(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"));
		assertFalse(list.isEmpty());
		list.remove(0);
		assertTrue(list.isEmpty());
	}
	
	/**
	 * tests LinkedList's remove() method
	 */
	@Test
	public void testRemove(){
		LinkedList list = new LinkedList();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.add(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"));
		list.add(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"));
		list.add(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"));
		list.add(new Task("Eat", "Eat lots of food", new Date(), new Date(), c1, "T4"));
		assertEquals(4, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		assertEquals(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"), list.get(1));
		assertEquals(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"), list.get(2));
		assertEquals(new Task("Eat", "Eat lots of food", new Date(), new Date(), c1, "T4"), list.get(3));
		list.remove(3);
		assertEquals(3, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		assertEquals(new Task("Do Lab", "finish the lab before my team kills me", new Date(), new Date(), c1, "T2"), list.get(1));
		assertEquals(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"), list.get(2));
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals(new Task("Do Project 3", "finish this project before I drop dead", new Date(), new Date(), c1, "T1"), list.get(0));
		assertEquals(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"), list.get(1));
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals(new Task("Sleep", "sleep at some point", new Date(), new Date(), c1, "T3"), list.get(0));
		list.remove(0);
		assertEquals(0, list.size());
	}

}
