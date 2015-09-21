package demo.graph;

import demo.fundamental.Stack;

public class DeptFirstPaths {

	/**
	 * @param args
	 */
	
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public DeptFirstPaths(Graph g, int s){
		this.s = s;
		edgeTo = new int[g.V()];
		dfs(g, s);
	}
	
	public void dfs(Graph g, int v){
		marked[v] = true;
		for(int w : g.adj(v)){
			if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(hasPathTo(v)){
			Stack<Integer> stack = new Stack<Integer>();
			for(int w = v; w != s; w = edgeTo[w]){
					stack.push(v);
			}
			stack.push(s);
			return stack;
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
