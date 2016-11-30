package edu.ncsu.csc216.todolist.ui;

import java.awt.Color;
import java.awt.FlowLayout;
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
	private JTextArea taskDetails;
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
		this(new TaskData(), list);
		
	}
	
	/**
	 * Creates a new edit pane with the given TaskData.
	 * @param data The data to initialize this TaskEditPane with
	 * @param list The CategoryList to show in this TaskEditPane
	 */
	public TaskEditPane(TaskData data, CategoryList list){
		super();
		this.data = data;
		add = false;
		edit = false;
		init();
	}
	
	/**
	 * Initializes the GUI.
	 */
	private void init(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.black));
		initView();
		fillFields();
	}
	
	/**
	 * Initializes the view.
	 */
	private void initView(){
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Task ID: ", SwingConstants.LEFT));
		p.add(getTaskID());
		this.add(p);
		
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Task Title: ", SwingConstants.LEFT));
		p.add(getTaskTitle());
		this.add(p);
		
		
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Category: ", SwingConstants.LEFT));
		p.add(getCategory());
		this.add(p);
		
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Start Date & Time: ", SwingConstants.LEFT));
		p.add(getTaskStartSpinner());
		this.add(p);
		
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Due Date & Time: ", SwingConstants.LEFT));
		p.add(getTaskDueSpinner());
		this.add(p);
		
		
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Completed Date & Time: ", SwingConstants.LEFT));
		p.add(getTaskCompletedSpinner());
		p.add(new JLabel("Completed? ", SwingConstants.LEFT));
		p.add(getComplete());
		this.add(p);
		
		p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel("Task Details: ", SwingConstants.LEFT));
		p.add(getTaskDetails());
		this.add(p);
	}
	
	/**
	 * Gets the Spinner for Task's start date
	 * @return The Spinner for Task's start date 
	 */
	JSpinner getTaskStartSpinner(){
		if (null == taskStart) {
			taskStart = new JSpinner();
			taskStart.setVisible(true);
		}
		return taskStart;
	}
	
	/**
	 * Gets the Spinner for Task's due date
	 * @return The Spinner for Task's due date
	 */
	JSpinner getTaskDueSpinner(){
		if (null == taskDue) {
			taskDue = new JSpinner();
			taskDue.setVisible(true);
		}
		return taskDue;
	}
	
	/**
	 * Gets the Spinner for Task's completed date
	 * @return The Spinner for Task's completed date
	 */
	JSpinner getTaskCompletedSpinner(){
		if (null == taskCompleted) {
			taskCompleted = new JSpinner();
			taskCompleted.setVisible(true);
		}
		return taskCompleted;
	}
	
	/**
	 * Gets the displayed Task start date
	 * @return The displayed Task start date
	 */
	Date getTaskStart(){
		return data.getStartDateTime();
	}
	
	/**
	 * Gets the displayed Task's due date
	 * @return The displayed Task's due date
	 */
	Date getTaskDue(){
		return data.getDueDateTime();
	}
	
	/**
	 * Gets the displayed Task's completed date
	 * @return The displayed Task's completed date
	 */
	Date getTaskCompleted(){
		return data.getCompletedDateTime();
	}
	
	/**
	 * Gets the text field for the Task's ID
	 * @return The text field for the displayed Task's ID
	 */
	JTextField getTaskID(){
		if (null == taskID) {
			taskID = new JTextField(10);
			taskID.setEditable(false);
			taskID.setVisible(true);
			taskID.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return taskID;
	}
	
	/**
	 * Gets the text field for the Task's title
	 * @return The text field for the Task's title
	 */
	JTextField getTaskTitle(){
		if (null == taskTitle) {
			taskTitle = new JTextField(40);
			taskTitle.setEditable(false);
			taskTitle.setVisible(true);
			taskTitle.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return taskID;
	}
	
	/**
	 * Gets the combo box of the Task's category
	 * @return The combo box of the Task's category
	 */
	JComboBox<Category> getCategory(){
		if (null == taskCat) {
			taskCat = new JComboBox<Category>();
			taskCat.setEditable(false);
			taskCat.setVisible(true);
		}
		return taskCat;
	}
	
	/**
	 * Gets the text area for the Task's details
	 * @return The text area for the Task's details
	 */
	JTextArea getTaskDetails(){
		if (null == taskDetails) {
			taskDetails = new JTextArea();
			taskDetails.setEditable(false);
			taskDetails.setVisible(true);
		}
		return taskDetails;
	}
	
	/**
	 * Gets the check box for whether or not the Task is complete
	 * @return The check box for whether or not the Task is complete
	 */
	JCheckBox getComplete(){
		if (null == complete) {
			complete = new JCheckBox();
			complete.setVisible(true);
		}
		return complete;
	}
	
	/**
	 * Sets the Task's start date
	 * @param date The date to set this Pane's startDate to
	 */
	void setTaskStart(Date date){
		if(date == null){
			throw new IllegalArgumentException();
		}
		this.data = new TaskData(data.getTaskID(), data.getTitle(), data.getCategory(), date,
				data.getDueDateTime(), data.getCompletedDateTime(), data.isCompleted(), data.getDetails());
	}
	
	/**
	 * Sets the Task's due date
	 * @param date The date to set as the Task's due date
	 */
	void setTaskDue(Date date){
		if(date == null){
			throw new IllegalArgumentException();
		}
		this.data = new TaskData(data.getTaskID(), data.getTitle(), data.getCategory(), data.getStartDateTime(),
				date, data.getCompletedDateTime(), data.isCompleted(), data.getDetails());
	}
	
	/**
	 * Sets the date when the Task was completed
	 * @param date The date when the Task was completed
	 */
	void setTaskComplete(Date date){
		if(date == null){
			throw new IllegalArgumentException();
		}
		this.data = new TaskData(data.getTaskID(), data.getTitle(), data.getCategory(), data.getStartDateTime(),
				data.getDueDateTime(), date, data.isCompleted(), data.getDetails());
	}
	
	/**
	 * Determines if the pane is in add mode
	 * @return true if the pane is in add mode
	 */
	boolean isAddMode(){
		return add;
	}
	
	/**
	 * Determines is the pane is in edit mode
	 * @return true if the pane is in edit mode
	 */
	boolean isEditMode(){
		return edit;
	}
	
	/**
	 * enables add mode
	 */
	void enableAdd(){
		if(!add){
			add = true;
			edit = false;
		}
		clearFields();
	}
	
	/**
	 * disables add mode
	 */
	void disableAdd(){
		add = false;
		clearFields();
	}
	
	/**
	 * Enables edit mode for the parameterized data
	 * @param data The TaskData to enable editing
	 */
	void enableEdit(TaskData data){
		if(!edit){
			edit = true;
			add = false;
			this.data = data;
			fillFields();
		}
	}
	
	/**
	 * Disables edit mode
	 */
	void disableEdit(){
		edit = false;
		clearFields();
	}
	
	/**
	 * Returns true if the required fields are not empty.
	 * @return true if the required fields are not empty
	 */
	boolean fieldsNotEmpty(){
		return getTaskTitle().getDocument().getLength() != 0 && getTaskStartSpinner().getValue() != null &&
				getTaskDueSpinner().getValue() != null && getCategory().getSelectedItem() != null;
	}
	
	/**
	 * Initializes TaskData to the given value
	 * @param data The new TaskData to set
	 */
	void setTaskData(TaskData data){
		this.data = data;
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
