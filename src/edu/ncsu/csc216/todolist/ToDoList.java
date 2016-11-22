package edu.ncsu.csc216.todolist;

import java.io.*;
import java.util.*;

import edu.ncsu.csc216.todolist.model.CategoryList;
import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * The main class for the ToDoList program.  Holds references to the top-level 
 * data structures that contain Task and Category objects and acts as the controller
 * between the model and the GUI presentation view.
 * 
 * @author David Wright
 * @version 1.0
 * 
 */
public class ToDoList extends Observable implements Serializable, Observer {
	
	
	private static final long serialVersionUID = 34992L;
	
	
	/**
	 * Increment for increasing the capacity of the array of TaskLists
	 */
	private static final int RESIZE = 3;
	
	
	private TaskList[] tasks;
	
	private int numLists;
	
	private CategoryList categories;
	
	private String filename;
	
	private boolean changed;
	
	private int nextTaskListNum;
	
	/**
	 * Constructor for ToDoList
	 */
	public ToDoList(){
		
	}
	
	/**
	 * Determines whether or not this ToDoList is changed
	 * @return true if this ToDoList has been changed
	 */
	public boolean isChanged(){
		//TODO implement method
		return false;
	}
	
	/**
	 * Sets the status of this ToDoList to changed or not
	 * @param c Whether or not this ToDoList is changed
	 */
	public void setChanged(boolean c){
		
	}
	
	/**
	 * Gets the file name of this ToDoList
	 * @return The File name of this ToDoList
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the file name of this ToDoList
	 * @param filename the name of the file to use
	 */
	public void setFilename(String filename) {
		//TODO implement method
		//this.filename = filename;
	}
	
	private int getNextTaskListNum(){
		//TODO implement method
		return 0;
	}
	
	private void incNextTaskListNum(){
		nextTaskListNum++;
	}
	
	/**
	 * Gets the number of active Task Lists
	 * @return the number of Task Lists
	 */
	public int getNumTaskLists(){
		//TODO implement method
		return 0;
	}
	
	/**
	 * Gets a specific TaskList
	 * @param listIdx The index of the TaskList to retrieve
	 * @return The TaskList with the given index
	 */
	public TaskList getTaskList(int listIdx){
		//TODO implement method
		return null;
	}
	
	/**
	 * Gets this ToDoList's CategoryList
	 * @return The CategoryList associated with this ToDoList
	 */
	public CategoryList getCategoryList(){
		//TODO implement method
		return null;
	}
	
	/**
	 * Adds a Task to this ToDoList's List of TaskLists
	 * @return WHAT DOES THIS EVEN RETURN???
	 */
	public int addTask(){
		//TODO implement method
		return 0;
	}
	
	/**
	 * Removes a TaskList with the specified index
	 * @param listIdx the index to remove a TaskList
	 */
	public void removeTaskList(int listIdx){
		
	}
	
	/**
	 * Saves the CategoryList and the array of TaskLists to the given file using 
	 * object serialization.  
	 * @param fname filename to save ToDoList information to.
	 */
	public void saveDataFile(String fname) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fname);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for (int i = 0; i < numLists; i++) {
				out.writeObject(tasks[i]);
			}
			out.writeObject(categories);
			out.writeObject(filename);
			out.writeInt(nextTaskListNum);
			changed = false;
			out.close();
			fileOut.close();
		}
		catch (IOException e) {
			System.err.println("An error occurred while saving file " + fname);
			e.printStackTrace(System.err);
		}
	}
	
	/**
	 * Opens a data file with the given name and creates the data structures from 
	 * the serialized objects in the file.
	 * @param fname filename to create ToDoList information from.
	 */
	public void openDataFile(String fname) {
		if (changed) {
			saveDataFile(filename);
		}
		try {
			FileInputStream fileIn = new FileInputStream(fname);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<TaskList> temp = new ArrayList<TaskList>();
			Object tl = in.readObject();
			while (tl instanceof TaskList) {
				TaskList l = (TaskList)tl;
				l.addObserver(this);
				temp.add(l);
				tl = in.readObject();
			}
			tasks = new TaskList[RESIZE];
			tasks = temp.toArray(tasks);
			numLists = temp.size();
			categories = (CategoryList)tl;
			categories.addObserver(this);
			filename = (String)in.readObject();
			nextTaskListNum = (int)in.readInt();
			changed = false;
			in.close();
			fileIn.close();
			
		}
		catch (IOException e) {
			System.err.println("An error occurred while reading file " + fname);
			e.printStackTrace(System.err);
		}
		catch (ClassNotFoundException c) {
			System.err.println("Error reconstructing ToDoList from file " + fname);
			c.printStackTrace(System.err);
		}
	}

	/**
	 * 
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
}