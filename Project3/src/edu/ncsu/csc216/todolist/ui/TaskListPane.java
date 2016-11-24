package edu.ncsu.csc216.todolist.ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * Represents a visual display pane for a Task List
 * @author Justin Schwab
 *
 */
public class TaskListPane extends JScrollPane implements Observer {

	private static final long serialVersionUID = -2210716111020406799L;
	private TaskList tasks;
	private JTable table;
	private int[] colWidths;
	private TaskTableModel ttm;
	
	/**
	 * Constructs a TaskListPane
	 * @param taskList The TaskList to display in this TaskListPane
	 */
	public TaskListPane(TaskList taskList) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets this TaskListPane's TaskTableModel
	 * @return The TaskTableModel
	 */
	public TaskTableModel getTaskTableModel(){
		return null;
	}
	
	/**
	 * Gets this TaskListPane's JTable of Tasks
	 * @return The JTable of Tasks
	 */
	public JTable getTable(){
		return null;
	}
	
	/**
	 * I HAVE NO IDEA WHAT THIS DOES
	 */
	private void initView(){
		
	}
	
	/**
	 * I HAVE NO IDEA WHAT THIS DOES EITHER
	 */
	public void clearSection(){
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
