package demo.graph;

import demo.In;
import demo.fundamental.Bag;
import demo.fundamental.Stack;
/*
 * 4.1.3
 */
public class Graph {
	private int V;
	private int E;
	private Bag<Integer> []adj;
	
	public Graph(int v){
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	public Graph(Graph g){
		this(g.V());
		this.E = g.E();
		for(int v = 0; v < g.V(); v++){
			Stack<Integer> reverse = new Stack<Integer>();
			for(int w : g.adj(v)){
				reverse.push(w);
			}
			
			for(int w : reverse){
				this.addEdge(v, w);
			}
		}
	}
	
	public Graph(In in){
		this.V = in.readInt();
		this.E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int e = in.readInt();
			addEdge(v, e);
		}
	}
	
	public void addEdge(int v, int e){
		adj[v].add(e);
		adj[e].add(v);
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
