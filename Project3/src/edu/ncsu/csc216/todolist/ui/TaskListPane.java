package edu.ncsu.csc216.todolist.ui;

import java.awt.Color;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import edu.ncsu.csc216.todolist.model.TaskList;

/**
 * Represents a visual display pane for a Task List
 * @author Justin Schwab
 * @author Zach Scott
 */
public class TaskListPane extends JScrollPane implements Observer, Serializable {
	/** Id used for serialization */
	private static final long serialVersionUID = -2210716111020406799L;
	/** List of tasks */
	private TaskList tasks;
	/** Table used to display the tasks in the list */
	private JTable table;
	/** Widths of the columns of the table */
	private int[] colWidths = {200, 200, 200};
	/** Model of the Task Table */
	private TaskTableModel ttm;
	
	/**
	 * Constructs a TaskListPane
	 * @param taskList The TaskList to display in this TaskListPane
	 */
	public TaskListPane(TaskList taskList) {
		super();
		this.tasks = taskList;
		this.tasks.addObserver(this);
		ttm = new TaskTableModel(tasks.get2DArray());
		initView();
	}
	
	/**
	 * Gets this TaskListPane's TaskTableModel
	 * @return The TaskTableModel
	 */
	public TaskTableModel getTaskTableModel(){
		return ttm;
	}
	
	/**
	 * Gets this TaskListPane's JTable of Tasks
	 * @return The JTable of Tasks
	 */
	public JTable getTable(){
		return table;
	}
	
	/**
	 * Initializes the view by creating the JTable (that is wrapped in  JScrollPane)
	 * and associating the JTable with the TaskTableModel.
	 */
	private void initView(){
		table = new JTable(ttm);
		//Set up the column widths so the table will look nice.
		for (int i = 0; i < colWidths.length; i++) {
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(colWidths[i]);
		}
		//Set the table so that only one row can be selected at a time.
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(false);
		setViewportView(table);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
	
	/**
	 * Clears the table
	 */
	public void clearSelection(){
		table.clearSelection();
	}

	/**
	 * This method is called by the observed object, whenever the observed object
	 * is changed.  In this case, the observed object is the TaskList. Any changes 
	 * to the TaskList will lead to an update of the TaskTableModel.
	 * @param o the observable object
	 * @param arg any additional information needed about the change.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof TaskList) {
			TaskList tl = (TaskList)o;
			//If there is a different number of rows, create a show new CategoryTableModel.
			if (tl.size() != ttm.getRowCount()) {
				 ttm = new TaskTableModel(tl.get2DArray());
				 table.setModel(ttm);
			} else {
				//Otherwise, just update the values directly.
				Object[][] arr = tl.get2DArray();
				for(int i = 0; i < arr.length; i++){
					Object temp = arr[i][2];
					for(int j = 2; j < 6; j++){
						arr[i][j] = arr[i][j + 1];
					}
					arr[i][6] = temp;
					boolean check = (boolean) arr[i][5];
					if(!check){
						arr[i][4] = null;
					}
				}
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < ttm.getColumnCount(); j++) {
						ttm.setValueAt(arr[i][j], i, j);
					}
				}
			}
		}
	}
}
