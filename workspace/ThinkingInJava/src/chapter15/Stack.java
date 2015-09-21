package chapter15;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

	private Node first = null;
	
	public void push(Item item){
		first = new Node(item, first);
	}
	
	public Item pop(){
		if(first == null)
			return null;
		Item item = first.item;
		if(!first.end())
			first = first.next;
		return item;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class Node{
		Item item;
		Node next;
		public Node(){
			item = null;
			next = null;
		}
		public Node(Item item, Node next){
			Node n = new Node();
			n.item = item;
			n.next = next;
		}
		
		public boolean end(){
			return item == null && next == null;
		}
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
			if(hasNext()){
				Item item = current.item;
				current = current.next;
				return item;
			}
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			System.out.println("remove");
		}
		
	}
}
