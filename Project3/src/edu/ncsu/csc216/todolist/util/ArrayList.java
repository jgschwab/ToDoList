package edu.ncsu.csc216.todolist.util;

import java.io.Serializable;

import edu.ncsu.csc216.todolist.model.Category;

/**
 * Custom ArrayList for ToDoList
 * @author Justin Schwab
 *
 */
public class ArrayList implements List, Serializable {
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
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for(int i = 0; i < size; i++){
			if(list[i].equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Object get(int index) {
		return list[index];
	}
	
	@Override
	public boolean add(Object item) {
		try{
			add(size, item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void add(int idx, Object item) {
		if(item == null){
			throw new NullPointerException();
		}
		
		if(!(item instanceof Category)){
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < size; i++){
			if(item.equals(list[i])){
				throw new IllegalArgumentException();
			}
		}
		if(idx < 0 || idx > size){
			throw new IndexOutOfBoundsException();
		}
		
		if(size + 1 == list.length){
			growArray();
		}
		
		//actually add it
		if(idx != size){
			for(int i = size; i >= idx; i--){
				list[i + 1] = list[i];
			}
			list[idx] = item;
			size++;
		} else{
			list[size] = item;
			size++;
		}
	}

	@Override
	public Object remove(int idx) {
		if (idx < 0 || idx >= size || size == 0) {
			throw new IndexOutOfBoundsException();
		}
		Object ret = list[idx];
		for (int i = idx; i < size + 1; i++) {
			list[i] = list[i + 1];
		}
		list[size] = null;
		size--;
		return ret;
	}

	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < size; i++){
			if(list[i] == o){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Doubles the length of array
	 */
	private void growArray(){
		Object[] tempList = new Object[list.length * 2];
		for(int i = 0; i < list.length; i++){
			tempList[i] = list[i];
		}
		list = tempList;
	}

}
