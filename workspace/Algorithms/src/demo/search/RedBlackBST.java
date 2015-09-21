package demo.search;


public class RedBlackBST <Key extends Comparable<Key>, Value>{

	/**
	 * @param args
	 */
	private final static boolean RED = true;
	private final static boolean BLACK = false;
	private Node root;
	
	private class Node {
		private Value val;
		private Key key;
		private Node left;
		private Node right;
		private int N;
		private boolean color;
		public Node(Key key, Value val, int n, boolean color) {
			this.val = val;
			this.key = key;
			this.N = n;
			this.color = color;
		}
	}

	public boolean isRed(Node x){
		if(x == null)
			return false;
		return x.color == RED;
	}
	
	public int size(Node x){
		if(x == null)
			return 0;
		return x.N;
	}
	
	public Node rotateLeft(Node x){
		Node h = x.right;
		x.right = h.left;
		h.left = x;
		h.color = x.color;
		x.color = RED;
		h.N = x.N;
		x.N = size(x.left) + size(x.right) + 1;
		return h;
	}
	
	public Node rotateRight(Node x){
		Node h = x.left;
		x.left = h.right;
		h.color = x.color;
		x.color = RED;
		h.right = x;
		h.N = x.N;
		x.N = size(x.left) + size(x.right) + 1;
		return h;
	}
	
	public void put(Key k, Value v){
		root = put(root, k, v);
		root.color = BLACK;
	}
	public Node put(Node x, Key k, Value v){
		if(x == null)
			return new Node(k, v, 1, RED);
		int cmp = k.compareTo(x.key);
		if(cmp < 0)
			put(x.left, k, v);
		else if(cmp > 0)
			put(x.right, k, v);
		else
			x.val = v;
		
		if(isRed(x.right) && !isRed(x.left))
			x = rotateLeft(x);
		if(isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		if(isRed(x.left) && isRed(x.right))
			flipColors(x);
		return x;
	}
	
	public void flipColors(Node x){
		if(x == null)
			return;
		x.right.color= BLACK;
		x.left.color = BLACK;
		x.color = RED;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
