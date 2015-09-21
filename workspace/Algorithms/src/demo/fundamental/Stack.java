package demo.fundamental;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{

	/**
	 * @param args
	 */
	
	private int N;
	private Node first;
	
	//helper linked list class
	private class Node{  
		private Item item;
		private Node next;
	}
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}
		
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	public Stack(){
		first = null;
		N = 0;
		assert check();
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
		assert check();
	}
	
	public Item pop(){
		if(isEmpty()){
			System.out.println("empty stack");
			return null;
		}
		Item item = first.item;
		first = first.next;
		N--;
		assert check();
		return item;
	}
	
	public Item peek(){
		if(isEmpty())
			throw new NoSuchElementException("Stack underflow");
			return first.item;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(Item item: this)
			s.append(item + " ");
		return s.toString();
	}
	
	private boolean check(){
		if(N == 0){
			if(first != null)
				return false;
		}else if(N == 1){
			if(first == null) 
				return false;
			if(first.next != null) 
				return false;
		}else{
			if(first.next == null)
				return false;
		}
		
		int numberOfNodes = 0;
		for(Node x =  first; x != null; x = x.next){
			numberOfNodes++;
		}
		if(numberOfNodes != N)
			return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<String>();
		String sTest = "[]()[](";
		int i = 0;
		for(i = 0; i < sTest.length(); i++){
			if(sTest.charAt(i) == '('||sTest.charAt(i) == '['||sTest.charAt(i) == '{')
				s.push(String.valueOf(sTest.charAt(i)));
			else if(sTest.charAt(i) == ')'||sTest.charAt(i) == ']'||sTest.charAt(i) == '}')
			{
				String popValue = s.pop();
				if((sTest.charAt(i) == ')' && !popValue.equals("(")) || (sTest.charAt(i) == ']' && !popValue.equals("[")) ||
				    (sTest.charAt(i) == '}' && !popValue.equals("{")))
				    break;
			}
		}
		
		if(i == sTest.length() && s.isEmpty())
			System.out.println("true");
		else
			System.out.println("false");
	}

	

}
