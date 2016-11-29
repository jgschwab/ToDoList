package edu.ncsu.csc216.todolist.util;

import java.io.Serializable;

/**
 * Custom LinkedList for this ToDoList
 * @author Justin Schwab
 *
 */
public class LinkedList implements List, Serializable {
	private static final long serialVersionUID = 349987L;
	private Node head;
	private int size;
	
	/**
	 * Constructs an empty LinkedList
	 */
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	/**
	 * List Node for this LinkedList
	 * @author Justin Schwab
	 *
	 */
	class Node implements Serializable {
		private static final long serialVersionUID = 484909840L;
		private Node next;
		Object data;
		
		/**
		 * Constructs a new Node with value and next
		 * @param o The object that is this Node's data
		 * @param n This Node's "next" reference
		 */
		public Node(Object o, Node n){
			data = o;
			next = n;
		}
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
		if(isEmpty()){ //check if empty
			return false;
		}
		if(size == 1 && !head.data.equals(o)){ //check head if size is 1
			return false;
		}
		Node temp = head;
		if(head.data.equals(o)){ //check front if size > 1
			return true;
		}
		while(temp.next != null){ //check the rest if size > 1
			if(temp.next.data.equals(o)){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		Node current = head;
		if(size == 1 || index == 0){
			return head.data;
		}
		
		for(int i = 1; i < index; i++){
			current = current.next;
			
		}
		return current.next.data;
	}

	@Override
	public boolean add(Object o) {
		if(o == null){
			throw new NullPointerException("Can't add null elements");
		}
		try{
			add(size, o);
			return true;
		} catch(Exception e){
			return false;
		}
	}
	
	@Override
	public void add(int index, Object element) {
		if(element == null) {
			throw new NullPointerException("Can't add null elements");
		}
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		if(contains(element)){
			throw new IllegalArgumentException("Can't add duplicate elements");
		}
		
		Node current = head;
		if(index == 0){
			Node temp = new Node(element, head);
			head = temp;
			size++;
		} else{
			for(int i = 1; i < index; i++){
				current = current.next;
			}
			
			if(current.next != null){ //add in middle of list
				Node temp = new Node(element, current.next);
				current.next = temp;
				size++;
			} else{ //add at end of list
				Node temp = new Node(element, null);
				current.next = temp;
				size++;
			}
		}
	}

	@Override
	public Object remove(int index) {
		Object o = get(index);
		if(size == 1){
			head = null;
			size--;
		} else if(index == 0){
			head = head.next;
			size--;
		} else{
			Node current = head;
			for(int i = 1; i < index; i++){ //traverse to index 
				current = current.next;
			}
			if(current.next.next == null){ //remove at end of list
				current.next = null;
				size--;
			} else{
				current.next = current.next.next;
				size--;
			}
		}
		return o;
	}

	@Override
	public int indexOf(Object o) {
		if(o == null){
			throw new NullPointerException("can't index null elements");
		}
		for(int i = 0; i < size; i++){
			if(get(i).equals(o)){
				return i;
			}
		}
		return -1;
	}
	
	/*------------PRIVATE LINKEDLIST METHODS LISTED IN DESIGN-------------
	 * I will not be using these, as they are predicated on the notion that there
	 * is no head Node or size field. I'm not sure why this was the design;
	 * it's much more efficient to keep track of these instance variables
	
	private Node insertAt(int idx, Object o, Node n){
		return null;
	}
	
	private int indexOf(Object o, Node n, int i){
		return 0;
	}
	
	private Node remove(int i, Node n){
		return null;
	}
	
	private int size(Node n){
		return 0;
	}
	*/
}