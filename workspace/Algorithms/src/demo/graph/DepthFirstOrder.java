package demo.graph;

import demo.fundamental.Queue;
import demo.fundamental.Stack;

public class DepthFirstOrder {

	/**
	 * @param args
	 */
	private Queue<Integer> pre; //Ç°Ðò
	private Queue<Integer> post; //ºóÐò
	private Stack<Integer> reversePost;//ÄæºóÐò
	private boolean[] marked;
	
	public DepthFirstOrder(Digraph g){
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[g.V()];
		
		for(int v = 0; v < g.V(); v++){
			if(!marked[v])
				dfs(g, v);
		}
	}
	
	public void dfs(Digraph g, int v){
		marked[v] = true;
		pre.enqueue(v);
		for(int w : g.adj(v)){
			if(!marked[w])
				dfs(g, w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	
	public Iterable<Integer> post(){
		return post;
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
