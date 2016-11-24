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
	private JSpinner tastStart;
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
	 * 
	 */
	private void init(){
		//TODO implement
	}
	
	/**
	 * 
	 */
	private void initView(){
		//TODO implement
	}
	
	/**
	 * 
	 * @return
	 */
	JSpinner getTaskStartSpinner(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	JSpinner getTaskDueSpinner(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	JSpinner getTaskCompletedSpinner(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	Date getTaskStart(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	Date getTaskDue(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	Date getTaskCompleted(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	JTextField getTaskID(){
		//TODO implement
		return null;
	}
	
	JTextField getTaskTitle(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	JComboBox<Category> getCategory(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	JTextArea getTaskDetails(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	JCheckBox getComplete(){
		//TODO implement
		return null;
	}
	
	/**
	 * 
	 * @param date
	 */
	void setTaskStart(Date date){
		//TODO implement
	}
	
	/**
	 * 
	 * @param date
	 */
	void setTaskDue(Date date){
		//TODO implement
	}
	
	/**
	 * 
	 * @param date
	 */
	void setTaskComplete(Date date){
		//TODO implement
	}
	
	/**
	 * 
	 * @return
	 */
	boolean isAddMode(){
		//TODO implement
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	boolean isEditMode(){
		//TODO implement
		return false;
	}
	
	/**
	 * 
	 */
	void enableAdd(){
		//TODO implement
	}
	
	/**
	 * 
	 */
	void disableAdd(){
		//TODO implement
	}
	
	/**
	 * @param data The TaskData to enable editing
	 */
	void enableEdit(TaskData data){
		//TODO implement
	}
	
	/**
	 * 
	 */
	void disableEdit(){
		//TODO implement
	}
	
	/**
	 * 
	 * @return
	 */
	boolean fieldsNotEmpty(){
		//TODO implement
		return false;
	}
	
	/**
	 * 
	 * @param data
	 */
	void setTaskData(TaskData data){
		//TODO implement
	}
	
	/**
	 * 
	 * @param e
	 */
	void addFieldListener(EventListener e){
		//TODO implement
	}
	
	/**
	 * 
	 */
	void fillFields(){
		//TODO implement
	}
	
	/**
	 * 
	 */
	void clearFields(){
		//TODO implement
	}
	
	/**
	 * 
	 * @return
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
