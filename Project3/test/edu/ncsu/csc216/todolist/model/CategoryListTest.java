package edu.ncsu.csc216.todolist.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the CategoryList class
 * @author Justin Schwab
 * @author Zach Scott
 */
public class CategoryListTest {

	/**
	 * Tests CateogryList functions
	 */
	@Test
	public void test(){
		//Test Construction
		CategoryList catList = new CategoryList();
		assertEquals(0, catList.size());
		assertTrue(catList.isEmpty());
		assertEquals("Categories", catList.getName());
		
		//Add invalid categories
		assertFalse(catList.addCategory(null, "Cat Cafe Visitations"));
		assertEquals(0, catList.size());
		assertTrue(catList.isEmpty());
		
		assertFalse(catList.addCategory("", "Cat Cafe Visitations"));
		assertEquals(0, catList.size());
		assertTrue(catList.isEmpty());
		
		assertFalse(catList.addCategory("Cats and Coffee", ""));
		assertEquals(0, catList.size());
		assertTrue(catList.isEmpty());
		
		assertFalse(catList.addCategory("Cats and Coffee", null));
		assertEquals(0, catList.size());
		assertTrue(catList.isEmpty());
		
		//Add valid categories
		assertTrue(catList.addCategory("Cats and Coffee", "Cat Cafe Visitations"));
		assertEquals(1, catList.size());
		assertFalse(catList.isEmpty());
		Object[][] testArray = catList.get2DArray();
		assertEquals("C1", (String) testArray[0][0]);
		assertEquals("Cats and Coffee", (String) testArray[0][1]);
		assertEquals("Cat Cafe Visitations", (String) testArray[0][2]);
		
		assertTrue(catList.addCategory("Maids and Coffee", "Maid Cafe Visitations"));
		assertEquals(2, catList.size());
		testArray = catList.get2DArray();
		assertEquals("C1", (String) testArray[0][0]);
		assertEquals("Cats and Coffee", (String) testArray[0][1]);
		assertEquals("Cat Cafe Visitations", (String) testArray[0][2]);
		assertEquals("C2", (String) testArray[1][0]);
		assertEquals("Maids and Coffee", (String) testArray[1][1]);
		assertEquals("Maid Cafe Visitations", (String) testArray[1][2]);
		
		assertTrue(catList.addCategory("Aliens and Coffee", "Alien Cafe Visitations"));
		assertEquals(3, catList.size());
		testArray = catList.get2DArray();
		assertEquals("C1", (String) testArray[0][0]);
		assertEquals("Cats and Coffee", (String) testArray[0][1]);
		assertEquals("Cat Cafe Visitations", (String) testArray[0][2]);
		assertEquals("C2", (String) testArray[1][0]);
		assertEquals("Maids and Coffee", (String) testArray[1][1]);
		assertEquals("Maid Cafe Visitations", (String) testArray[1][2]);
		assertEquals("C3", (String) testArray[2][0]);
		assertEquals("Aliens and Coffee", (String) testArray[2][1]);
		assertEquals("Alien Cafe Visitations", (String) testArray[2][2]);
		
		assertTrue(catList.addCategory("Too Much Coffee", "It hurts..."));
		assertEquals(4, catList.size());
		testArray = catList.get2DArray();
		assertEquals("C1", (String) testArray[0][0]);
		assertEquals("Cats and Coffee", (String) testArray[0][1]);
		assertEquals("Cat Cafe Visitations", (String) testArray[0][2]);
		assertEquals("C2", (String) testArray[1][0]);
		assertEquals("Maids and Coffee", (String) testArray[1][1]);
		assertEquals("Maid Cafe Visitations", (String) testArray[1][2]);
		assertEquals("C3", (String) testArray[2][0]);
		assertEquals("Aliens and Coffee", (String) testArray[2][1]);
		assertEquals("Alien Cafe Visitations", (String) testArray[2][2]);
		assertEquals("C4", (String) testArray[3][0]);
		assertEquals("Too Much Coffee", (String) testArray[3][1]);
		assertEquals("It hurts...", (String) testArray[3][2]);
		
		//Test retrieval methods
		for(int i = 0; i < catList.size(); i++) {
			Category temp = (Category) catList.getCategoryAt(i);
			assertEquals("C" + (i + 1), temp.getCategoryID());
		}
		
		assertEquals(new Category("C2", "Maids and Coffee", "Maid Cafe Visitations"), catList.getCategoryAt(1));
		
		for(int i = 0; i < catList.size(); i++) {
			String id = "C" + (i + 1);
			assertEquals(i, catList.indexOf(id));
		}
		assertEquals(-1, catList.indexOf("_"));
		
		assertEquals(0, catList.indexOfName("Cats and Coffee"));
		assertEquals(1, catList.indexOfName("Maids and Coffee"));
		assertEquals(2, catList.indexOfName("Aliens and Coffee"));
		assertEquals(3, catList.indexOfName("Too Much Coffee"));
		assertEquals(-1, catList.indexOfName("Never Too Much Coffee"));
		
		//Invalid Remove
		assertFalse(catList.removeCategory("_"));
		
		try{
			catList.removeCategoryAt(100000);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, catList.size());
		}
		try{
			catList.removeCategoryAt(-100000);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, catList.size());
		}
		
		//Remove from the middle of the list (Removal via id)
		assertTrue(catList.removeCategory("C2"));
		assertEquals(3, catList.size());
		testArray = catList.get2DArray();
		assertEquals("C1", (String) testArray[0][0]);
		assertEquals("Cats and Coffee", (String) testArray[0][1]);
		assertEquals("Cat Cafe Visitations", (String) testArray[0][2]);
		assertEquals("C3", (String) testArray[1][0]);
		assertEquals("Aliens and Coffee", (String) testArray[1][1]);
		assertEquals("Alien Cafe Visitations", (String) testArray[1][2]);
		assertEquals("C4", (String) testArray[2][0]);
		assertEquals("Too Much Coffee", (String) testArray[2][1]);
		assertEquals("It hurts...", (String) testArray[2][2]);
		
		//Remove from the front of the list (Removal via index)
		Category temp = new Category("C1", "Cats and Coffee", "Cat Cafe Visitation");
		assertEquals(temp, catList.removeCategoryAt(0));
		assertEquals(2, catList.size());
		testArray = catList.get2DArray();
		assertEquals("C3", (String) testArray[0][0]);
		assertEquals("Aliens and Coffee", (String) testArray[0][1]);
		assertEquals("Alien Cafe Visitations", (String) testArray[0][2]);
		assertEquals("C4", (String) testArray[1][0]);
		assertEquals("Too Much Coffee", (String) testArray[1][1]);
		assertEquals("It hurts...", (String) testArray[1][2]);
		
		//Remove from the back of the list (Removal via id)
		assertTrue(catList.removeCategory("C4"));
		assertEquals(1, catList.size());
		assertFalse(catList.isEmpty());
		testArray = catList.get2DArray();
		assertEquals("C3", (String) testArray[0][0]);
		assertEquals("Aliens and Coffee", (String) testArray[0][1]);
		assertEquals("Alien Cafe Visitations", (String) testArray[0][2]);
		
		//Remove the last element from the list (Removal via index)
		temp = new Category("C3", "Aliens and Coffee", "Alien Cafe Visitations");
		assertEquals(temp, catList.removeCategoryAt(0));
		assertEquals(0, catList.size());
		assertTrue(catList.isEmpty());
	}
	
}
