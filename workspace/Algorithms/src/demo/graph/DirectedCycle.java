package demo.graph;

import demo.fundamental.Stack;

public class DirectedCycle {

	/**
	 * @param args
	 */
	private boolean[] marked;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	private int[] edgeTo;
	public DirectedCycle(Digraph g){
		marked = new boolean[g.V()];
		onStack = new boolean[g.V()];
		edgeTo = new int[g.V()];
		for(int v = 0; v < g.V(); v++){
			if(!marked[v])
				dfs(g, v);
		}
	}
	
	public void dfs(Digraph g, int v){
		marked[v] = true;
		onStack[v] = true;
		
		for(int w : g.adj(v)){
			if(hasCycle())
				return;
			else if(!marked[w]){
				edgeTo[w] = v;
				dfs(g, w);
			}
			else if(onStack[w]){
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		
		onStack[v] = false;
	}
	
	public boolean hasCycle(){
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
