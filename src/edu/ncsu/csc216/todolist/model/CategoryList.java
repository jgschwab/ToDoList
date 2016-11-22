package edu.ncsu.csc216.todolist.model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * Class to maintain the List of Categories
 * @author Justin Schwab
 *
 */
public class CategoryList implements Tabular, Serializable, Observer  {
	private static final long serialVersionUID = 984509L;

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
