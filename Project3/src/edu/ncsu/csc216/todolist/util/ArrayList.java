package edu.ncsu.csc216.todolist.util;


/**
 * Custom ArrayList for ToDoList
 * @author Justin Schwab
 *
 */
public class ArrayList implements List {

	private static final long serialVersionUID = 28592L;
	/** The initial size of array. */
	private static final int INIT_SIZE = 10;
	/** The array of type Object */
	private Object[] list;
	/** The size of the ArrayList . */
	private int size;
	
	/**
	 * Constructs new Object array for this Array List, and sets size to 0
	 */
	public ArrayList(){
		this(INIT_SIZE);
	}
	
	/**
	 * Constructs new Object array for this ArrayList, with the parameterized initial size
	 * @param initSize The initial size of this ArrayList
	 */
	public ArrayList(int initSize){
		list = new Object[initSize];
		size = 0;
	}
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
