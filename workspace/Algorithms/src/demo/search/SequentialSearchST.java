package demo.search;

import demo.fundamental.Queue;

public class SequentialSearchST<Key, Value> {

	
	/**
	 * 3.1.5
	 * @param args
	 */
	private int N;
	private Node first;
	
	private class Node{
		Key k;
		Value v;
		Node next;
		public Node(Key k, Value v, Node next){
			this.k = k;
			this.v = v;
			this.next = next;
		}
	}//end node
	
	public int size(){
		return N;
	}
	
	public Value get(Key key){
		for(Node x = first; x != null; x = x.next){
			if(x.k.equals(key)){
				return x.v;
			}
		}
		return null;
	}
	
	public void delete(Key key){
		first = delete(first, key);
	}
	
	public Node delete(Node x, Key k){
		if(x == null)
			return null;
		if(k.equals(x.k)){
			N--;
			return x.next;
		}
		x.next = delete(x.next, k);
		return x;
	}
	public void put(Key key, Value val){
		if(val == null)
		{
			delete(key);
			return;
		}
		for(Node x = first; x != null; x = x.next){
			if(x.k.equals(key))
				x.v = val;
			return;
		}
		Node temp = new Node(key, val, first);
		first = temp;
		N++;
		
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		for(Node x = first; x != null; x = x.next){
			q.enqueue(x.k);
		}
		return q;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
