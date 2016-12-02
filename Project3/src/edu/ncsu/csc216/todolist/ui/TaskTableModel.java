package edu.ncsu.csc216.todolist.ui;

import java.io.Serializable;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import edu.ncsu.csc216.todolist.model.Category;

/**
 * TaskTableModel is a wrapper for the information in TaskList that 
 * can be used by a JTable. 
 * @author Justin Schwab
 * @author Zach Scott
 */
public class TaskTableModel extends AbstractTableModel implements Serializable {
	private static final long serialVersionUID =  5954551753060998701L;
	private String[] colNames = {"ID", "Title", "Start Date", "Due Date", "Completed Date", "Complete", "Category"};
	private Object[][] data;
	
	/** 
	 * Creates the model from the given data.
	 * @param data the data to populate the TableModel
	 */
	public TaskTableModel(Object[][] data){
		this.data = data;
	}
	
	/**
	 * Returns the number of rows in the data.
	 * @return the number of rows in the data
	 */
	@Override
	public int getRowCount(){
		if (data == null) {
			return 0;
		}
		return data.length;
	}
	
	/**
	 * Returns the number of columns in the data.
	 * @return the number of columns in the data 
	 */
	@Override
	public int getColumnCount(){
		return colNames.length;
	}
	
	/**
	 * Returns the column name at the given index.
	 * @param col the index for finding the column name
	 * @return the column name at the given index
	 */
	@Override
	public String getColumnName(int col){
		return colNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col){
		if (data == null) {
			return null;
		}
		return data[row][col];
	}
	
	@Override
	public void setValueAt(Object obj, int row, int col){
		data[row][col] = obj;
		fireTableCellUpdated(row, col);
	}
	
	/**
	 * Returns the TaskData object associated with the given
	 * row in the TableModel.
	 * @param row the TaskData to return
	 * @return the TaskData for the given row
	 */
	public TaskData getTaskRowData(int row){
		TaskData ret = new TaskData((String) data[row][0], (String) data[row][1], (Category) data[row][2], (Date) data[row][3], 
				(Date) data[row][4], (Date) data[row][5], (boolean) data[row][6], (String) data[row][7]);
		return ret;
	}
	
	/**
	 * Sets the given row with the provided TaskData.
	 * @param idx The index to set the given TaskData to
	 * @param data The data to set at the given index
	 */
	public void setTaskRowData(int idx, TaskData data){
		this.data[idx] = data.getDataArray();
	}
}