package demo.search;

import demo.fundamental.Queue;
import demo.fundamental.Stack;

public class NonrecursiveBST<Key extends Comparable<Key>, Value> {

	/**
	 * @param args
	 */
	Node root;
	
	private class Node{
		Key key;
		Value value;
		Node left, right;
		
		public Node(Key key, Value v){
			this.key = key;
			this.value = v;
		}
	}
	
	public Value get(Key key){
		Node x = root;
		while(x != null){
			int cmp = key.compareTo(x.key);
			if(cmp == 0)
				return x.value;
			if(cmp < 0)
				x = x.left;
			if(cmp > 0)
				x =x.right;
		}
		return null;
	}
	
	public void put(Key key, Value value){
		Node n = new Node(key, value);
		if(root == null)
		{
			root = n;
			return;
		}
		
		Node parent = null;
		Node x = root;
		while(x != null){
			parent = x;
			int cmp = key.compareTo(x.key);
			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
			else
			{
				x.value = value;
				return;
			}
		}
		int cmp = key.compareTo(parent.key);
		if(cmp < 0)
			parent.left = n;
		else
			parent.right = n;
	}
	
	public Iterable<Key> keys(){
		Stack<Node> s = new Stack<Node>();
		Queue<Key> q = new Queue<Key>();
		Node x = root;
		while(x != null || !s.isEmpty()){
			if(x != null){
				s.push(x);
				x = x.left;
			}
			else{
				x= s.pop();
				q.enqueue(x.key);
				x = x.right;
			}
		}
		return q;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
