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
 * A ToDoList controls the value of a TaskList's id when adding a TaskList to the array 
 * of TaskLists. Each TaskList id starts with "TL", and is appended with a number. 
 * The number starts at 1 and is incremented after each TaskList is successfully added 
 * to the array of TaskLists. This ensures that each TaskList has a unique id . The field 
 * nextTaskListNum represents the value that will be appended to the next TaskList added 
 * to the array of TaskLists.
 * 
 * @author David Wright
 * @author Justin Schwab
 * @version 1.0
 * 
 */
public class ToDoList extends Observable implements Serializable, Observer {
	/** ID for object serialization */
	private static final long serialVersionUID = 34992L;
	/**
	 * Increment for increasing the capacity of the array of TaskLists
	 */
	private static final int RESIZE = 3;
	
	/** The array of TaskLists that this ToDoList keeps track of */
	private TaskList[] tasks;
	/** The number of TaskLists */
	private int numLists = 0;
	/** The CategoryList associated with this ToDoList */
	private CategoryList categories;
	/** The file name associated with this ToDoList */
	private String filename;
	/** Whether or not this ToDoList has been changed */
	private boolean changed;
	/** Counter for the next taskList number used for assigining IDs */
	private int nextTaskListNum = 1;
	
	/**
	 * Constructs the ToDoList by doing the following: 
	 * 1. Constructs the tasks array with at least three elements.
	 * 2. Constructs a TaskList called "New List" and adds it to element 0 of the tasks array. 
	 * The ToDoList instance should be an Observer of the TaskList.
	 * 3. Constructs a new CategoryList. The ToDoList instance should be an 
	 * Observer of the CategoryList.
	 * 4. Changed is set to false.
	 */
	public ToDoList(){
		tasks = new TaskList[3];
		addTaskList();
		categories = new CategoryList();
		categories.addObserver(this);
		tasks[0].addObserver(this);
	}
	
	/**
	 * Determines whether or not this ToDoList is changed
	 * @return true if this ToDoList has been changed
	 */
	public boolean isChanged(){
		return changed;
	}
	
	/**
	 * Sets the status of this ToDoList to changed or not
	 * @param c Whether or not this ToDoList is changed
	 */
	public void setChanged(boolean c){
		changed = c;
	}
	
	/**
	 * Gets the file name of this ToDoList
	 * @return The File name of this ToDoList
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * If the filename parameter is null or the empty string an IllegalArgumentException is thrown. 
	 * Otherwise, the filename field is set.
	 * @param filename the name of the file to use
	 */
	public void setFilename(String filename) {
		if(filename == null || filename.length() == 0){
			throw new IllegalArgumentException("Invalid File Name");
		}
		this.filename = filename;
	}
	
	/**
	 * Gets the next TaskList number for assigning IDs
	 * @return the next TaskList number
	 */
	private int getNextTaskListNum(){
		int num = this.nextTaskListNum;
		incNextTaskListNum();
		return num;
	}
	
	private void incNextTaskListNum(){
		nextTaskListNum++;
	}
	
	private void growArray(){
		int newSize = tasks.length + RESIZE;
		TaskList[] temp = new TaskList[newSize];
		for(int i = 0; i < numLists; i++){
			temp[i] = tasks[i];
		}
		tasks = temp;
	}
	
	/**
	 * Gets the number of active Task Lists
	 * @return the number of Task Lists
	 */
	public int getNumTaskLists(){
		return numLists;
	}
	
	/**
	 * Returns the TaskList at the given index. If the index < 0 or the index >= size() 
	 * an IndexOutOfBoundsException is thrown.
	 * @param idx The index of the TaskList to retrieve
	 * @return The TaskList with the given index
	 */
	public TaskList getTaskList(int idx){
		if(idx < 0 || idx >= numLists){
			throw new IndexOutOfBoundsException();
		}
		return tasks[idx];
	}
	
	/**
	 * Gets this ToDoList's CategoryList
	 * @return The CategoryList associated with this ToDoList
	 */
	public CategoryList getCategoryList(){
		return categories;
	}
	
	/**
	 * Returns the index of the added TaskList. The tasks array should be resized 
	 * to accommodate new TaskLists. Every TaskList added should have the ToDoList 
	 * instance added as an Observer. The Observers of ToDoList are notified of the 
	 * change. The added TaskList object is passed to notifyObservers().
	 * @return The index of the added TaskList
	 */
	public int addTaskList(){
		if(numLists == tasks.length){
			growArray();
		}
		TaskList tlist = new TaskList("New List", "TL" + getNextTaskListNum());
		int i = 0;
		while(tasks[i] != null){
			i++;
		}
		tasks[i] = tlist;
		tlist.addObserver(this);
		this.notifyObservers(tlist);
		numLists++;
		return i;
	}
	
	/**
	 * Removes the TaskList at the given index. The ToDoList instance is removed 
	 * as an Observer of the removed TaskList. The Observers of ToDoList are notified 
	 * of the change. If the index < 0 or the index >= size() an IndexOutOfBoundsException 
	 * is thrown. The removed TaskList object is passed to notifyObservers().
	 * @param index the index to remove a TaskList
	 */
	public void removeTaskList(int index){
		if(index < 0 || index >= numLists){
			throw new IndexOutOfBoundsException();
		}
		TaskList removed = getTaskList(index);
		tasks[index] = null;
		//shift
		for(int i = index; i < tasks.length - 1; i++){
			tasks[i] = tasks[i + 1];
		}
		tasks[tasks.length - 1] = null;
		removed.deleteObserver(this);
		notifyObservers(removed);
		numLists--;
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

	@Override
	public void update(Observable o, Object arg) {
		setChanged(true);
		notifyObservers(arg);
	}
}