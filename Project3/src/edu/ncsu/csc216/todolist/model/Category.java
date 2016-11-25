package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * A representation of a Category in this ToDoList application
 * @author Justin Schwab
 *
 */
public class Category extends Observable implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = 459188L;
	private String categoryID;
	private String name;
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
	 */
	public void setName(String name) {
		this.name = name;
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
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 */
	private void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public int compareTo(Object o) {
		return this.categoryID.compareTo(((Category) o).getCategoryID());
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryID == null) ? 0 : categoryID.hashCode());
		return result;
	}


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

	
	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", categoryID=" + categoryID + "]";
	}
}
