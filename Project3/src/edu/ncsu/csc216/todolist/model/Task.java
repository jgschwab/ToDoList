package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * A representation of a Task in the ToDoList application; 
 * a Task has a Category.
 * @author Justin Schwab
 *
 */

public class Task extends Observable implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = 7459L;
	private String title;
	private String details;
	private Date startDateTime;
	private Date dueDateTime;
	private Category category;
	private Date completedDateTime;
	private boolean completed;
	private String taskID;
	
	/**
	 * Constructs a new Task; throws an IllegalArgumentException if any of the parameters 
	 * that shouldn't be null or the empty string are null or the empty string.
	 * @param title The Title of this Task
	 * @param details The details of this Task
	 * @param startDateTime The starting time of this Task
	 * @param dueDateTime The due date of this Task
	 * @param category The Category that this Task belongs to
	 * @param taskID The ID of this Task
	 */
	public Task(String title, String details, Date startDateTime,
			Date dueDateTime, Category category, String taskID){
		setTitle(title);
		setDetails(details);
		setStartDateTime(startDateTime);
		setDueDateTime(dueDateTime);
		setCategory(category);
		setTaskID(taskID);
	}

	/**
	 * Gets the title of this Task
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the tile of this Task
	 * If the title parameter is null or the empty string, an IllegalArgumentException is thrown. 
	 * Otherwise, the title field is set and Observers of Task are notified of the change.
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		//TODO implement method
		this.title = title;
	}

	/**
	 * Gets the details of this Task
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets the details of this Task
	 * The details parameter can be null or the empty string. The field is set and 
	 * Observers of Task are notified of the change.
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		//TODO implement method
		this.details = details;
	}

	/**
	 * Gets the start time of this Task
	 * @return the startDateTime
	 */
	public Date getStartDateTime() {
		return startDateTime;
	}

	/**
	 * Sets the start date and time of this Task
	 * If the startDateTime parameter is null, an IllegalArgumentException is thrown. 
	 * Otherwise, the startDateTime field is set and Observers of Task are notified of the change.
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(Date startDateTime) {
		//TODO implement method
		this.startDateTime = startDateTime;
	}

	/**
	 * Gets the due date and time of this Task
	 * @return the dueDateTime
	 */
	public Date getDueDateTime() {
		return dueDateTime;
	}

	/**
	 * Sets the due date and time of this Task.
	 * If the dueDateTime is null, an IllegalArgumentException is thrown. Otherwise, the 
	 * startDateTime field is set and Observers of Task are notified of the change.
	 * @param dueDateTime the dueDateTime to set
	 */
	public void setDueDateTime(Date dueDateTime) {
		//TODO implement method
		this.dueDateTime = dueDateTime;
	}
	
	/**
	 * Gets the day and time on which this Task was completed
	 * @return the completedDateTime
	 */
	public Date getCompletedDateTime() {
		return completedDateTime;
	}

	/**
	 * Sets the date on which this Task was completed.
	 * The completedDateTime parameter can be null. The field is set and Observers of Task 
	 * are notified of the change.
	 * @param completedDateTime the completedDateTime to set
	 */
	public void setCompletedDateTime(Date completedDateTime) {
		//TODO implement method
		this.completedDateTime = completedDateTime;
	}

	/**
	 * Gets the Category of this Task
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets the Category of this Task.
	 * If the c parameter is null, an IllegalArgumentException is thrown. Otherwise, 
	 * the category field is set and Observers of Task are notified of the change.
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		//TODO implement method
		this.category = category;
	}

	/**
	 * Determines if this Task is completed or not
	 * @return Whether or not this Task is completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Sets the completion status of this Task
	 * The field is set and Observers of Task are notified of the change.
	 * @param completed Whether or not this Task should be marked as Completed
	 */
	public void setCompleted(boolean completed) {
		//TODO implement method
		this.completed = completed;
	}

	/**
	 * Gets the Task ID of this Task
	 * @return the taskID
	 */
	public String getTaskID() {
		return taskID;
	}

	/**
	 * Sets the Task ID of this Task.
	 * If the id parameter is null or the empty string, an IllegalArgumentException is thrown. 
	 * Otherwise, the taskId field is set and Observers of Task are notified of the change.
	 * @param taskID the taskID to set
	 */
	private void setTaskID(String taskID) {
		//TODO implement method
		this.taskID = taskID;
	}

	@Override
	public int compareTo(Object arg0) {
		return this.dueDateTime.compareTo(((Task) arg0).getDueDateTime());
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskID == null) ? 0 : taskID.hashCode());
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
		Task other = (Task) obj;
		if (taskID == null) {
			if (other.taskID != null)
				return false;
		} else if (!taskID.equals(other.taskID))
			return false;
		return true;
	}
}
