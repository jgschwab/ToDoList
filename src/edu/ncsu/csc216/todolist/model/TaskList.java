package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.todolist.util.LinkedList;

/**
 * A class to maintain the List of Tasks 
 * @author Justin Schwab
 *
 */
public class TaskList extends Observable implements Tabular, Serializable, Observer {

	private static final long serialVersionUID = 98734509L;
	private LinkedList list;
	private String name;
	private int nextTaskNum;
	private String taskListID;
	private Date start;
	private Date start2;
	
	/**
	 * Constructs TaskList; sets nextTaskNum to 1, and sets the fields with the parameter values. 
	 * The behaviors defined for setName() apply when constructing a TaskList with the given parameters. 
	 * taskListID should never be null or an empty string. Throws an IllegalArgumentException if any of 
	 * the parameters are null or the empty string
	 * @param name The name of the TaskList
	 * @param id The ID of the TaskList
	 */
	public TaskList(String name, String id){
		//TODO implement
	}
	
	/**
	 * Gets the name of this TaskList
	 * @return The name of this TaskList
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Sets the name of this TaskList
	 * @param name The name to set to this TaskList
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Gets this TaskList's ID
	 * @return This TaskList's taskListID
	 */
	public String getTaskListID(){
		//TODO implement method
		return null;
	}
	
	private void setTaskListID(String id){
		this.taskListID = id;
	}
	
	private int getNextTaskNum(){
		//TODO implement method
		return 0;
	}
	
	/**
	 * Increments the variable for the next Task ID
	 */
	private void incNextTaskNum(){
		nextTaskNum++;
	}
	
	/**
	 * Adds a Task to this TaskList
	 * @param title The title of the Task to add
	 * @param description The description of the Task to add
	 * @param start The starting Date of the Task to add
	 * @param due The due date of the Task to add
	 * @param c The Category of the Task to add
	 * @return true if the Task was added, false if not
	 */
	public boolean addTask(String title, String description, Date start, Date due, Category c){
		//TODO implement method
		return false;
	}
	
	/**
	 * Gets the Task at the given index
	 * @param idx The index of the Task to return
	 * @return The Task at the given index
	 */
	public Task getTaskAt(int idx){
		//TODO implement method
		return null;
	}
	
	/**
	 * Gets the index of a specified Task
	 * @param id The ID of the Task to get the index of
	 * @return The index of the parameterized Task
	 */
	public int indexOf(String id){
		//TODO implement method
		return 0;
	}
	
	/**
	 * Gets the size of this TaskList
	 * @return The size of this TaskList
	 */
	public int size(){
		//TODO implement method
		return 0;
	}
	
	/**
	 * Determines if this TaskList is empty
	 * @return true if the TaskList is empty
	 */
	public boolean isEmpty(){
		//TODO implement method
		return false;
	}
	
	/**
	 * Removes the Task at the specified index
	 * @param idx The index of the Task to remove
	 * @return The Task that was removed
	 */
	public Task removeTaskAt(int idx){
		//TODO implement method
		return null;
	}
	
	/**
	 * Removes the Task with the specified ID 
	 * @param id the ID of the Task to remove
	 * @return true if the Task was removed
	 */
	public boolean removeTask(String id){
		//TODO implement method
		return false;
	}
	
	/**
	 * Gets the data of this TaskList as a 2D array
	 * @return The Tasks in this TaskList and their data
	 */
	public Object[][] get2DArray(){
		//TODO implement method
		return null;
	}
	
	/**
	 * If a Task in the TaskList changes, the update() method is automatically called. 
	 * TaskList should propagate the notification of the change to its Observers IF the 
	 * Observable o is contained in the list of Tasks. 
	 * The arg parameter is passed to notifyObservers().
	 */
	@Override
	public void update(Observable obs, Object arg){
		
	}
}
