package demo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demo.In;
import demo.fundamental.Bag;

public class EdgeWeightedGraph {
	private int E;
	private int V;
	private Bag<Edge>[] adj;
//	private List<Edge> list;
	public EdgeWeightedGraph(){}
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V){
		this.V = V;
		E = 0;
		adj = (Bag<Edge>[]) new Bag[V + 1];
		
//		list = new ArrayList<Edge>();
		
		for(int i = 0; i <= V; i++)
			adj[i] = new Bag<Edge>();
	}
	
	public void initialize(Scanner scanner){
		E = scanner.nextInt();
		
		Edge edge;
		for(int i = 0; i < E; i++){
			int w = scanner.nextInt();
			int v = scanner.nextInt();
			float weight = scanner.nextFloat();
			edge = new Edge(w, v, weight);
			this.addEdge(edge);
		}
		scanner.close();
	}
	
	public void setE(int E){
		this.E = E;
	}
	
	public EdgeWeightedGraph(In in){
		
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(Edge e){
		int node1 = e.either();
		int node2 = e.other(node1);
		adj[node1].add(e);
		adj[node2].add(e);
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> bag = new Bag<Edge>();
		for(int v = 0; v <= V; v++){
			for(Edge e : adj[v])
				if(e.other(v) > v)
					bag.add(e);
		}
		
		return bag;
	}
}
