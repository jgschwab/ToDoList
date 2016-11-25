package edu.ncsu.csc216.todolist.ui;

import javax.swing.table.AbstractTableModel;

/**
 * TaskTableModel is a wrapper for the information in TaskList that 
 * can be used by a JTable. 
 * @author Justin Schwab
 *
 */
public class TaskTableModel extends AbstractTableModel {
	private static final long serialVersionUID =  5954551753060998701L;
	private String[] colNames;
	private Object[][] data;
	
	/** 
	 * Creates the model from the given data.
	 * @param data the data to populate the TableModel
	 */
	public TaskTableModel(Object[][] data){
		//TODO implement
	}
	
	/**
	 * Returns the number of rows in the data.
	 * @return the number of rows in the data
	 */
	@Override
	public int getRowCount(){
		//TODO implement
		return -1;
	}
	
	/**
	 * Returns the number of columns in the data.
	 * @return the number of columns in the data 
	 */
	@Override
	public int getColumnCount(){
		//TODO implement
		return -1;
	}
	
	/**
	 * Returns the column name at the given index.
	 * @param col the index for finding the column name
	 * @return the column name at the given index
	 */
	@Override
	public String getColumnName(int col){
		//TODO implement
		return null;
	}
	
	@Override
	public Object getValueAt(int row, int col){
		//TODO implement
		return null;
	}
	
	@Override
	public void setValueAt(Object obj, int row, int col){
		//TODO implement
	}
	
	/**
	 * Returns the TaskData object associated with the given
	 * row in the TableModel.
	 * @param row the TaskData to return
	 * @return the TaskData for the given row
	 */
	public TaskData getTaskRowData(int row){
		//TODO implement
		return null;
	}
	
	/**
	 * Sets the given row with the provided TaskData.
	 * @param idx The index to set the given TaskData to
	 * @param data The data to set at the given index
	 */
	public void setTaskRowData(int idx, TaskData data){
		//TODO implement
	}
}