package edu.ncsu.csc216.todolist.util;

/**
 * Custom LinkedList for this ToDoList
 * @author Justin Schwab
 *
 */
public class LinkedList implements List {

	private static final long serialVersionUID = 349987L;
	private Node head;
	
	/**
	 * Constructs an empty LinkedList
	 */
	public LinkedList(){
		
	}
	
	/**
	 * List Node for this LinkedList
	 * @author Justin Schwab
	 *
	 */
	class Node {
		private static final long serialVersionUID = 484909840L;
		private Node next;
		protected Object value;
		/**
		 * Constructs a new Node with value and next
		 * @param o The object that is this Node's data
		 * @param n This Node's "next" reference
		 */
		public Node(Object o, Node n){
			
		}
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
	
	//------------PRIVATE LINKEDLIST METHODs-------------
	
	private Node insertAt(int idx, Object o, Node n){
		//TODO implement method
		return null;
	}
	
	private int indexOf(Object o, Node n, int i){
		//TODO implement method
		return 0;
	}
	
	private Node remove(int i, Node n){
		//TODO implement method
		return null;
	}
	
	private int size(Node n){
		//TODO implement method
		return 0;
	}

}
