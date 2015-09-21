package demo.search;

import demo.fundamental.Queue;

/**
 * P277 3.2.6
 * @author Home
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value>{

	private Node root;
	
	
	private class Node{
		private Value val;
		private Key key;
		private Node left;
		private Node right;
		private int N;
		private int height;
		
		public Node(Value val, Key key, int n, int height){
			this.val = val;
			this.key = key;
			this.N = n;
			this.height = height;
		}
	}
	
	public int reheight(Node node){
		if(node == null)
			return -1;
		return reheight(node.left) > reheight(node.right) ? reheight(node.left) + 1 : reheight(node.right) + 1;
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(Node node){
		if(node == null)
			return 0;
		return node.height;
	}
	
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x == null)
			return 0;
		return x.N;
	}
	
	public Value get(Key key){
		return get(root, key);
	}
	private Value get(Node x, Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return get(x.left, key);
		else if(cmp > 0)
			return get(x.right, key);
		return x.val;
	}
	
	public void put(Key key, Value value){
		root = put(root, key, value);
	}
	private Node put(Node x, Key key, Value value){
		if(x == null)
			return new Node(value, key, 1, 0);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			x.right = put(x.right, key, value);
		else if(cmp > 0)
			x.left = put(x.left, key, value);
		else
			x.val = value;
		x.N = size(x.left) + size(x.right) + 1;
		x.height = reheight(x);
		//x.height = height(x.right) > height(x.left) ? height(x.right) + 1: height(x.left) + 1;
		return x;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public Key max(){
		if(isEmpty())
			return null;
		return max(root).key;
	}
	private Node max(Node x){
		if(x == null)
			return null;
		if(x.right == null)
			return x;
		return max(x.right);
	}
	public Key min(){
		if(isEmpty())
			return null;
		return min(root).key;
	}
	private Node min(Node n){
		if(n == null)
			return null;
		if(n.left == null)
			return n;
		else 
			return min(n.left);
	}
	
	public Key floor(Key key){
		Node x = floor(root, key);
		if(x == null)
			return null;
		return x.key;
	}
	private Node floor(Node x, Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return x;
		if(cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null)
			return t;
		else
			return x;
	}
	
	public Key ceiling(Key key){
		Node x = ceiling(root, key);
		if(x == null)
			return null;
		return x.key;
	}
	private Node ceiling(Node x, Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)
			return x;
		else if(cmp > 0)
			return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if(t != null)
			return t;
		return x;
	}
	
	public Key select(int k){
		Node x = select(root, k);
		if(x == null)
			return null;
		return x.key;
	}
	private Node select(Node x, int k){
		if(x == null)
			return null;
		int cmpleft = size(x.left);
		if(cmpleft > k)
			return select(x.left, k);
		else if(cmpleft < k)
			return select(x.right, k - cmpleft - 1);
		return x;
	}
	
	public int rank(Key k){
		return rank(root, k);
	}
	private int rank(Node x, Key k){
		if(x == null)
			return -1;
		int cmp = k.compareTo(x.key);
		if(cmp < 0)
			return rank(x.left, k);
		else if(cmp > 0)
			return 1 + size(x.left) + rank(x.right, k);
		return size(x.left);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node x){
		if(x == null)
			return null;
		if(x.left == null)
		{
			return x.right;
		}
		else{
			x.left = deleteMin(x.left);
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
	}
	
	public void delete(Key key){
		root = delete(root, key);
	}
	public Node delete(Node x, Key k){
		if(x == null)
			return null;
		int cmp = k.compareTo(x.key);
		if(cmp == 0){
			if(x.left == null)
				return x.right;
			if(x.right == null)
				return x.left;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		else if(cmp < 0)
			x.left = delete(x.left, k);
		else
			x.right = delete(x.right, k);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Iterable<Key> keys(){
		return keys(min(), max());
	}
	private Iterable<Key> keys(Key min, Key max){
		Queue<Key> q = new Queue<Key>();
		keys(root, q, min, max);
		return q;
	}
	private void keys(Node x, Queue<Key> q, Key min, Key max){
		if(x == null)
			return;
		int cmplo = min.compareTo(x.key);
		int cmphi = max.compareTo(x.key);
		if(cmplo <= 0 && cmphi >= 0)
			q.enqueue(x.key);
		if(cmplo < 0)
			keys(x.left, q, min, max);
		if(cmphi > 0)
			keys(x.right, q, min, max);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
