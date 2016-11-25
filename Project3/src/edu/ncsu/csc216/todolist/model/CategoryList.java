package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.todolist.util.ArrayList;

/**
 * Class to maintain the List of Categories
 * @author Justin Schwab
 * @author Zach Scott
 */
public class CategoryList extends Observable implements Tabular, Serializable, Observer  {
	/** Id used in serialization */
	private static final long serialVersionUID = 984509L;
	/** Name of the list */
	private String name;
	/** List of categories */
	private ArrayList list;
	/** Numeric component of the id that will be assigned to the next category added to the list */
	private int nextCategoryNum;
	
	/**
	 * Constructs the edu.ncsu.csc216.todolist.util.ArrayList and sets nextCategoryNum to 1
	 */
	public CategoryList(){
		name = "Categories";
		list = new ArrayList();
		nextCategoryNum = 1;
	}
	
	/**
	 * Gets the name of this CategoryList
	 * @return The name of this CategoryList
	 */
	public String getName(){
		return name;
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
		Category cat = null;
		try{
			cat = new Category("C" + getNextCategoryNum(), name, desc);
		} catch (IllegalArgumentException e) {
			return false;
		}
		cat.addObserver(this);
		list.add(cat);
		incNextCategoryNum();
		setChanged();
		notifyObservers(this);
		return true;
	}
	
	/**
	 * Gets the Category at the specified index
	 * @param idx The index of the Category to get
	 * @return The Category at the specified index
	 */
	public Category getCategoryAt(int idx){
		return (Category) list.get(idx);
	}
	
	/**
	 * Returns the index of the first occurrence of a Category that
	 * has an exact match to the provided id or -1 if there are no 
	 * Categories with an exact match on the given id.
	 * @param id The ID of the Category to look for
	 * @return If a category with the given id is in the list, then the index of the Category is returned.
	 * If a category with the given id is not in the list, -1 is returned.
	 */
	public int indexOf(String id){
		for(int i = 0; i < list.size(); i++) {
			Category temp = (Category) list.get(i);
			if(temp.getCategoryID().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of a Category that has an exact match 
	 * to the provided name or -1 if there are no Categories with an exact match on the given name.
	 * @param name The name of the Category to search for
	 * @return The index of the Category with the given name
	 */
	public int indexOfName(String name){
		for(int i = 0; i < list.size(); i++) {
			Category temp = (Category) list.get(i);
			if(temp.getName().equals(name)) {
				return i;
			}
		}
		return -1;
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
	 * @throws IndexOutOfBoundsException If the index < 0 or the index >= size()
	 */
	public Category removeCategoryAt(int idx){
		if(idx < 0 || idx >= list.size()) {
			throw new IndexOutOfBoundsException();
		}
		Category ret = (Category) list.get(idx);
		list.remove(idx);
		setChanged();
		notifyObservers(this);
		return ret;
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
		int index = indexOf(id);
		if(index < 0 || index > list.size()){
			return false;
		}
		list.remove(index);
		setChanged();
		notifyObservers(this);
		return true;
	}
	
	/**
	 * Gets the next ID to be used for naming Categories
	 * @return The next ID
	 */
	private int getNextCategoryNum(){
		return nextCategoryNum;
	}
	
	/**
	 * Increments the Category number to be used for naming the next Category
	 */
	private void incNextCategoryNum(){
		nextCategoryNum++;
	}
	
	/**
	 * Updates the list if category information is changed
	 * @param o the observed object
	 * @param arg argument to pass on to observers
	 */
	@Override
	public void update(Observable o, Object arg) {
		Category temp = (Category) o;
		int index = indexOf(temp.getCategoryID());
		if(index > 0 && index < list.size()){
			setChanged();
			notifyObservers(arg);
		}
	}

	/**
	 * Generates a 2D array containing information from the categories in the list
	 * @return a 2D array of category information.
	 * Each row represents a different category.
	 * Column one contains category id information.
	 * Column two contains category names.
	 * Column three contains category descriptions.
	 */
	@Override
	public Object[][] get2DArray() {
		Object[][] ret = new Object[list.size()][3];
		for(int i = 0; i < list.size(); i++){
			Category temp = getCategoryAt(i);
			ret[i][0] = temp.getCategoryID();
			ret[i][1] = temp.getName();
			ret[i][2] = temp.getDescription();
		}
		return ret;
	}
}
