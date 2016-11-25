package edu.ncsu.csc216.todolist.ui;

import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import edu.ncsu.csc216.todolist.model.CategoryList;
import edu.ncsu.csc216.todolist.model.Category;

/**
 * Panel for editing Tasks
 * @author Justin Schwab
 *
 */
public class TaskEditPane extends JPanel implements Observer {
	private static final long serialVersionUID = 5479139338455751629L;
	private CategoryList categories;
	private JTextField taskID;
	private JTextField taskTitle;
	private JComboBox<Category> taskCat;
	private JSpinner taskStart;
	private JSpinner taskDue;
	private JSpinner taskCompleted;
	private JCheckBox complete;
	private boolean add;
	private boolean edit;
	private TaskData data;
	
	/**
	 * Creates a new edit pane with an empty TaskData
	 * @param list The CategoryList to show in this TaskEditPane
	 */
	public TaskEditPane(CategoryList list){
		//TODO implement
	}
	
	/**
	 * Creates a new edit pane with the given TaskData.
	 * @param data The data to initialize this TaskEditPane with
	 * @param list The CategoryList to show in this TaskEditPane
	 */
	public TaskEditPane(TaskData data, CategoryList list){
		//TODO implement
	}
	
	/**
	 * Initializes the GUI.
	 */
	private void init(){
		//TODO implement
	}
	
	/**
	 * Initializes the view.
	 */
	private void initView(){
		//TODO implement
	}
	
	/**
	 * Gets the Spinner for Task's start date
	 * @return The Spinner for Task's start date 
	 */
	JSpinner getTaskStartSpinner(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the Spinner for Task's due date
	 * @return The Spinner for Task's due date
	 */
	JSpinner getTaskDueSpinner(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the Spinner for Task's completed date
	 * @return The Spinner for Task's completed date
	 */
	JSpinner getTaskCompletedSpinner(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the displayed Task start date
	 * @return The displayed Task start date
	 */
	Date getTaskStart(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the displayed Task's due date
	 * @return The displayed Task's due date
	 */
	Date getTaskDue(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the displayed Task's completed date
	 * @return The displayed Task's completed date
	 */
	Date getTaskCompleted(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the text field for the Task's ID
	 * @return The text field for the displayed Task's ID
	 */
	JTextField getTaskID(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the text field for the Task's title
	 * @return The text field for the Task's title
	 */
	JTextField getTaskTitle(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the combo box of the Task's category
	 * @return The combo box of the Task's category
	 */
	JComboBox<Category> getCategory(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the text area for the Task's details
	 * @return The text area for the Task's details
	 */
	JTextArea getTaskDetails(){
		//TODO implement
		return null;
	}
	
	/**
	 * Gets the checkbox for whether or not the Task is complete
	 * @return The checkbox for whether or not the Task is complete
	 */
	JCheckBox getComplete(){
		//TODO implement
		return null;
	}
	
	/**
	 * Sets the Task's start date
	 * @param date The date to set this Pane's startDate to
	 */
	void setTaskStart(Date date){
		//TODO implement
	}
	
	/**
	 * Sets the Task's due date
	 * @param date The date to set as the Task's due date
	 */
	void setTaskDue(Date date){
		//TODO implement
	}
	
	/**
	 * Sets the date when the Task was completed
	 * @param date The date when the Task was completed
	 */
	void setTaskComplete(Date date){
		//TODO implement
	}
	
	/**
	 * Determines if the pane is in add mode
	 * @return true if the pane is in add mode
	 */
	boolean isAddMode(){
		//TODO implement
		return false;
	}
	
	/**
	 * Determines is the pane is in edit mode
	 * @return true if the pane is in edit mode
	 */
	boolean isEditMode(){
		//TODO implement
		return false;
	}
	
	/**
	 * enables add mode
	 */
	void enableAdd(){
		//TODO implement
	}
	
	/**
	 * disables add mode
	 */
	void disableAdd(){
		//TODO implement
	}
	
	/**
	 * Enables edit mode for the parameterized data
	 * @param data The TaskData to enable editing
	 */
	void enableEdit(TaskData data){
		//TODO implement
	}
	
	/**
	 * Disables edit mode
	 */
	void disableEdit(){
		//TODO implement
	}
	
	/**
	 * Returns true if the required fields are not empty.
	 * @return true if the required fields are not empty
	 */
	boolean fieldsNotEmpty(){
		//TODO implement
		return false;
	}
	
	/**
	 * Initializes TaskData to the given value
	 * @param data The new TaskData to set
	 */
	void setTaskData(TaskData data){
		//TODO implement
	}
	
	/**
	 * Adds event listeners to fields
	 * @param e The event listener to add to fields
	 */
	void addFieldListener(EventListener e){
		//TODO implement
	}
	
	/**
	 * Fills the fields with the appropriate text from the TaskData field
	 */
	void fillFields(){
		//TODO implement
	}
	
	/**
	 * Clears the fields by setting data to null.
	 */
	void clearFields(){
		data = null;
		fillFields();
	}
	
	/**
	 * Returns the fields as a TaskData object.
	 * @return the fields as a TaskData object
	 */
	TaskData getFields(){
		//TODO implement
		return null;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
