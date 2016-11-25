package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * A representation of a Category in this ToDoList application
 * @author Justin Schwab
 * @author Zach Scott
 */
public class Category extends Observable implements Comparable<Object>, Serializable {
	/** Id used in serialization */
	private static final long serialVersionUID = 459188L;
	/** Id of the category */
	private String categoryID;
	/** Name of the category */
	private String name;
	/** Description of the category */
	private String description;
	
	/**
	 * Constructs a Category
	 * @param name The name of the Category
	 * @param description The Category's description
	 * @param categoryID The Category's ID
	 */
	public Category(String categoryID, String name, String description){
		this.setName(name);
		this.setDescription(description);
		this.setCategoryID(categoryID);
	}

	/**
	 * Gets the name of this Category
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * If the name parameter is null or the empty string, an IllegalArgumentException is thrown. 
	 * Otherwise, the name field is set and Observers of Category are notified of the change.
	 * @param name the name to set
	 * @throws IllegalArgumentException if the name is null or empty
	 */
	public void setName(String name) {
		if(name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid Category Name");
		}
		this.name = name;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Gets this Category's description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * The description parameter can be null or the empty string. The field is set and Observers 
	 * of Category are notified of the change.
	 * @param description the description to set
	 * @throws IllegalArgumentException if the description is null or empty
	 */
	public void setDescription(String description) {
		if(description == null || description.length() == 0) {
			throw new IllegalArgumentException("Invalid Category Description");
		}
		this.description = description;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Gets the categoryID of this Category
	 * @return the categoryID
	 */
	public String getCategoryID() {
		return categoryID;
	}

	/**
	 * If the id parameter is null or the empty string an IllegalArgumentException is thrown. 
	 * Otherwise, the id field is set and Observers of Category are notified of the change.
	 * @param categoryID the categoryID to set
	 * @throws IllegalArgumentException if the category id is null or empty
	 */
	private void setCategoryID(String categoryID) {
		if(categoryID == null || categoryID.length() == 0) {
			throw new IllegalArgumentException("Invalid Category ID");
		}
		this.categoryID = categoryID;
	}

	/**
	 * Compares the category's id to that of a given category.
	 * @param o the object that the category is being compared to
	 * @return if the category's id succeeds the idea of the given category, then a negative integer is returned
	 * if the category's id precedes the idea of the given category, then a positive integer is returned.
	 * if the two categories have the same id, zero is returned
	 */
	@Override
	public int compareTo(Object o) {
		return this.categoryID.compareTo(((Category) o).getCategoryID());
	}

	/**
	 * Generates the hash code for the category
	 * @return the hash code for the category
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
		return result;
	}


	/**
	 * Checks for equality between a given object and the category
	 * @param obj the object to be compared to the category
	 * @return true if the objects are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryID == null) {
			if (other.categoryID != null)
				return false;
		} else if (!categoryID.equals(other.categoryID))
			return false;
		return true;
	}

	/**
	 * Generates a string containing information about the category
	 * @return a string containing information about the category
	 */
	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", categoryID=" + categoryID + "]";
	}
}
