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
	/** ID for serializing this TaskList */
	private static final long serialVersionUID = 98734509L;
	/** The list of Tasks */
	private LinkedList list;
	/** The name of this TaskList */
	private String name;
	/** The next number for generating a task ID */
	private int nextTaskNum;
	/** The ID for this TaskList */
	private String taskListID;
	
	/**
	 * Constructs TaskList; sets nextTaskNum to 1, and sets the fields with the parameter values. 
	 * The behaviors defined for setName() apply when constructing a TaskList with the given parameters. 
	 * taskListID should never be null or an empty string. Throws an IllegalArgumentException if any of 
	 * the parameters are null or the empty string
	 * @param name The name of the TaskList
	 * @param id The ID of the TaskList
	 */
	public TaskList(String name, String id){
		setName(name);
		setTaskListID(id);
		list = new LinkedList();
		nextTaskNum = 1;
	}
	
	/**
	 * Gets the name of this TaskList
	 * @return The name of this TaskList
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * If the name parameter is null or the empty string an IllegalArgumentException is thrown. 
	 * Otherwise, the name field is set and Observers of TaskList are notified of the change.
	 * @param name The name to set to this TaskList
	 */
	public void setName(String name){
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException("Invalid Name");
		}
		this.name = name;
	}
	
	/**
	 * Gets this TaskList's ID
	 * @return This TaskList's taskListID
	 */
	public String getTaskListID(){
		return this.taskListID;
	}
	
	private void setTaskListID(String id){
		if(id == null || id.length() == 0){
			throw new IllegalArgumentException("Invalid ID");
		}
		this.taskListID = id;
	}
	
	private int getNextTaskNum(){
		int num = this.nextTaskNum;
		incNextTaskNum();
		return num;
	}
	
	/**
	 * Increments the variable for the next Task ID
	 */
	private void incNextTaskNum(){
		nextTaskNum++;
	}
	
	/**
	 * Adds a Task to this TaskList.
	 * The Task is added to the list so that the list is always sorted by endDateTime. 
	 * Observers of TaskList are notified of the change if the Task is added to the list.
	 * @param title The title of the Task to add
	 * @param description The description of the Task to add
	 * @param start The starting Date of the Task to add
	 * @param due The due date of the Task to add
	 * @param c The Category of the Task to add
	 * @return true if the Task was added, false if not
	 */
	public boolean addTask(String title, String description, Date start, Date due, Category c){
		String id = taskListID + "-T" + getNextTaskNum();
		Task task = new Task(title, description, start, due, c, id);
		int i = 0;
		if(list.size() != 0 && task.compareTo((Task)list.get(list.size() - 1)) > 0){ //if element goes at the end
			list.add(task);
			setChanged();
			notifyObservers(this);
			return true;
		} else{
			while(list.size() != 0 && task.compareTo((Task)list.get(i)) > 0){ //if element goes anywhere else
				i++;
			}
		}
		list.add(i, task);
		setChanged();
		notifyObservers(this);
		return true;
	}
	
	/**
	 * Gets the Task at the given index
	 * @param idx The index of the Task to return
	 * @return The Task at the given index
	 */
	public Task getTaskAt(int idx){
		return (Task) list.get(idx);
	}
	
	/**
	 * Gets the index of a specified Task
	 * @param id The ID of the Task to get the index of
	 * @return The index of the parameterized Task
	 */
	public int indexOf(String id){
		for(int i = 0; i < list.size(); i++){
			Task task = (Task)list.get(i);
			if(task.getTaskID().equals(id)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Gets the size of this TaskList
	 * @return The size of this TaskList
	 */
	public int size(){
		return list.size();
	}
	
	/**
	 * Determines if this TaskList is empty
	 * @return true if the TaskList is empty
	 */
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	/**
	 * Removes the Task at the specified index
	 * @param idx The index of the Task to remove
	 * @return The Task that was removed
	 */
	public Task removeTaskAt(int idx){
		return (Task) list.remove(idx);
	}
	
	/**
	 * Removes the Task with the specified ID 
	 * @param id the ID of the Task to remove
	 * @return true if the Task was removed
	 */
	public boolean removeTask(String id){
		try{
			return list.remove(indexOf(id)) != null;
		} catch(IndexOutOfBoundsException e){
			return false;
		}
	}
	
	/**
	 * Gets the data of this TaskList as a 2D array
	 * @return The Tasks in this TaskList and their data
	 */
	public Object[][] get2DArray(){
		Object[][] arr = new Object[list.size()][8];
		for(int i = 0; i < list.size(); i++){
			arr[i][0] = ((Task)list.get(i)).getTaskID();
			arr[i][1] = ((Task)list.get(i)).getTitle();
			arr[i][2] = ((Task)list.get(i)).getCategory();
			arr[i][3] = ((Task)list.get(i)).getStartDateTime();
			arr[i][4] = ((Task)list.get(i)).getDueDateTime();
			arr[i][5] = ((Task)list.get(i)).getCompletedDateTime();
			arr[i][6] = ((Task)list.get(i)).isCompleted();
			arr[i][7] = ((Task)list.get(i)).getDetails();
		}
		return arr;
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
