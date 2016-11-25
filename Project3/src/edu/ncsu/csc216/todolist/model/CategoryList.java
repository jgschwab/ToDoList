package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.todolist.util.ArrayList;

/**
 * Class to maintain the List of Categories
 * @author Justin Schwab
 *
 */
public class CategoryList extends Observable implements Tabular, Serializable, Observer  {
	
	private static final long serialVersionUID = 984509L;
	private String name;
	private ArrayList list;
	private int nextCategoryNum;
	
	/**
	 * Constructs the edu.ncsu.csc216.todolist.util.ArrayList and sets nextCategoryNum to 1
	 */
	public CategoryList(){
		//TODO implement constructor
	}
	
	/**
	 * Gets the name of this CategoryList
	 * @return The name of this CategoryList
	 */
	public String getName(){
		//TODO implement method
		return null;
	}
	
	/**
	 * Returns true if the Category is added to the list and false otherwise. 
	 * The method constructs a Category using the provided parameters and creates
	 * a unique id for the Category using the nextCategoryNum as described above. 
	 * The Category is added to the list so that the list is always sorted by Category id. 
	 * Observers of CategoryList are notified of the change if the Category is added to the list.
	 * @param name The name of the Category
	 * @param desc The description of the Category
	 * @return true if the Category was added
	 */
	public boolean addCategory(String name, String desc){
		//TODO implement method
		return false;
	}
	
	/**
	 * Gets the Category at the specified index
	 * @param idx The index of the Category to get
	 * @return The Category at the specified index
	 */
	public Category getCategoryAt(int idx){
		//TODO implement method
		return null;
	}
	
	/**
	 * Returns the index of the first occurrence of a Category that
	 * has an exact match to the provided id or -1 if there are no 
	 * Categories with an exact match on the given id.
	 * @param id The ID of the Category to look for
	 * @return The index of the Category with the given ID
	 */
	public int indexOf(String id){
		//TODO implement method
		return -2;
	}
	
	/**
	 * Returns the index of the first occurrence of a Category that has an exact match 
	 * to the provided name or -1 if there are no Categories with an exact match on the given name.
	 * @param name The name of the Category to search for
	 * @return The index of the Category with the given name
	 */
	public int indexOfName(String name){
		//TODO implement method
		return -2;
	}
	
	/**
	 * Returns the number of Categories in the list.
	 * @return The number of Categories in the list.
	 */
	public int size(){
		return list.size();
	}
	
	/**
	 * Returns true if the list is empty and false otherwise.
	 * @return true if the list is empty
	 */
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	/**
	 * Returns the Category removed from the list at the given index and Observers of 
	 * CategoryList are notified of the change. The CategoryList should be removed as 
	 * an Observer of the removed Category. If the index < 0 or the index >= size() an
	 * IndexOutOfBoundsException is thrown.
	 * @param idx The index to remove a Category from
	 * @return The Category removed from the list at the given index
	 */
	public Category removeCategoryAt(int idx){
		//TODO implement method
		return null;
	}
	
	/**
	 * Returns true if the Category is removed from the list with an exact match on the given
	 * id and Observers of CategoryList are notified of the change. The method should be 
	 * implemented so there is no possibility of an IndexOutOfBoundsException being thrown 
	 * as a result of removing the Category. The CategoryList should be removed as an 
	 * Observer of the removed Category.
	 * @param id The ID of theCategory to remove
	 * @return true if the Category is removed
	 */
	public boolean removeCategory(String id){
		//TODO implement method
		return false;
	}
	
	/**
	 * Gets the next ID to be used for naming Categories
	 * @return The next ID
	 */
	private int getNextCategoryNum(){
		//TODO implement method
		return -1;
	}
	
	/**
	 * Increments the Category number to be used for naming the next Category
	 */
	private void incNextCategoryNum(){
		nextCategoryNum++;
	}
	
	//Observer
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	//Tabular
	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
