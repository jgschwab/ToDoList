package edu.ncsu.csc216.todolist.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;

import edu.ncsu.csc216.todolist.model.CategoryList;
import edu.ncsu.csc216.todolist.model.Category;

/**
 * Panel for editing Tasks
 * @author Justin Schwab
 * @author Zach Scott
 */
public class TaskEditPane extends JPanel implements Observer, ActionListener {
	/** Id used for serialization */
	private static final long serialVersionUID = 5479139338455751629L;
	/** List of categories */
	private CategoryList categories;
	/** Text field for the task id */
	private JTextField taskID;
	/** Text field for the task title */
	private JTextField taskTitle;
	/** Text field for the task details */
	private JTextArea taskDetails;
	/** Combo box for task category selection */
	private JComboBox<Category> taskCat;
	/** JSpinner for inputting task start time */
	private JSpinner taskStart;
	/** JSpinner for inputting task due time */
	private JSpinner taskDue;
	/** JSpinner for inputting task completion time */
	private JSpinner taskCompleted;
	/** Check box denoting the completion status of the task */
	private JCheckBox complete;
	/** Denotes if the Pane is in Add Mode */
	private boolean add;
	/** Denotes if the Pane is in Edit Mode */
	private boolean edit;
	/** Data of the selected task */
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
		categories = list;
		categories.addObserver(this);
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
		JCheckBox box = getComplete();
		box.addActionListener(this);
		p.add(box);
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
			taskStart = new JSpinner(new SpinnerDateModel());
			taskStart.setVisible(true);
			taskStart.setEnabled(false);
		}
		return taskStart;
	}

	/**
	 * Gets the Spinner for Task's due date
	 * @return The Spinner for Task's due date
	 */
	JSpinner getTaskDueSpinner(){
		if (null == taskDue) {
			taskDue = new JSpinner(new SpinnerDateModel());
			taskDue.setVisible(true);
			taskDue.setEnabled(false);
		}
		return taskDue;
	}

	/**
	 * Gets the Spinner for Task's completed date
	 * @return The Spinner for Task's completed date
	 */
	JSpinner getTaskCompletedSpinner(){
		if (null == taskCompleted) {
			taskCompleted = new JSpinner(new SpinnerDateModel());
			taskCompleted.setVisible(true);
			taskCompleted.setEnabled(false);
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
			taskID.setVisible(true);
			taskID.setEditable(false);
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
		return taskTitle;
	}

	/**
	 * Gets the combo box of the Task's category
	 * @return The combo box of the Task's category
	 */
	JComboBox<Category> getCategory(){
		if (null == taskCat) {
			taskCat = new JComboBox<Category>();
			for(int i = 0; i < categories.size(); i++){
				taskCat.addItem(categories.getCategoryAt(i));
			}
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
			taskDetails = new JTextArea(5, 70);
			taskDetails.setEditable(false);
			taskDetails.setVisible(true);
			taskDetails.setLineWrap(true);
			taskDetails.setAutoscrolls(true);
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
			edit = false;
			add = true;
			clearFields();
		}
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
			add = false;
			edit = true;
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
				getTaskDueSpinner().getValue() != null && getCategory().getSelectedItem() != null &&
						getTaskDetails().getDocument().getLength() != 0;
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
		getTaskID().getDocument().addDocumentListener((DocumentListener) e);
		getTaskTitle().getDocument().addDocumentListener((DocumentListener) e);
		getCategory().addActionListener((ActionListener) e);
		getTaskStartSpinner().getModel().addChangeListener((ChangeListener) e);
		getTaskDueSpinner().getModel().addChangeListener((ChangeListener) e);
		getTaskCompletedSpinner().getModel().addChangeListener((ChangeListener) e);
		getTaskDetails().getDocument().addDocumentListener((DocumentListener) e);
		getComplete().getModel().addChangeListener((ChangeListener) e);
	}

	/**
	 * Fills the fields with the appropriate text from the TaskData field
	 */
	void fillFields(){
		if(data == null){
			getTaskID().setText("");
			getTaskTitle().setText("");
			getCategory().getModel().setSelectedItem(null);
			getComplete().setSelected(false);
			getTaskDetails().setText("");
			taskTitle.setEditable(false);
			taskDetails.setEditable(false);
			taskStart.setEnabled(false);
			taskDue.setEnabled(false);
		} else {
			getTaskID().setText(data.getTaskID());
			getTaskTitle().setText(data.getTitle());
			getCategory().getModel().setSelectedItem(data.getCategory());
			if(data.getStartDateTime() != null)
				getTaskStartSpinner().setValue(data.getStartDateTime());
			if(data.getDueDateTime() != null)
				getTaskDueSpinner().setValue(data.getDueDateTime());
			if(data.getCompletedDateTime() != null)
				getTaskCompletedSpinner().setValue(data.getCompletedDateTime());

			getComplete().setSelected(data.isCompleted());
			getTaskDetails().setText(data.getDetails());
		}
		if(isAddMode() || isEditMode()){
			taskTitle.setEditable(true);
			taskDetails.setEditable(true);
			taskStart.setEnabled(true);
			taskDue.setEnabled(true);
		}
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
		String id = getTaskID().getText();
		String title = getTaskTitle().getText();
		String details = getTaskDetails().getText();
		Category cat = (Category) getCategory().getSelectedItem();
		Date start = (Date) getTaskStartSpinner().getModel().getValue();
		Date due = (Date) getTaskDueSpinner().getModel().getValue();
		Date completed = (Date) getTaskCompletedSpinner().getModel().getValue();
		boolean isComplete = getComplete().getModel().isSelected();
		TaskData ret = new TaskData(id, title, cat, start, due, completed, isComplete, details);
		return ret;
	}

	/**
	 * Updates the Pane if the category list has been changed.
	 * @param arg0 The observable that has been changed
	 * @param arg1 The message that that the observable send
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof CategoryList) {
			taskCat.removeAllItems();
			for(int i = 0; i < categories.size(); i++){
				taskCat.addItem(categories.getCategoryAt(i));
			}
		}
		TaskEditPane.this.repaint();
		TaskEditPane.this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(getComplete().getModel().isSelected()){
			taskCompleted.setEnabled(true);
		} else {
			taskCompleted.setEnabled(false);
		}
	}
}
