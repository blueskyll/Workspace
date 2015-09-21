package demo.graph;

import demo.fundamental.Bag;

public class Digraph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < V; i++)
			adj[i] = new Bag<Integer>();
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public Digraph reverse(){
		Digraph g = new Digraph(V);
		for(int i = 0; i < V; i++){
			for(int w : adj[i]){
				g.addEdge(w, i);
			}
		}
		return g;
	}
}
