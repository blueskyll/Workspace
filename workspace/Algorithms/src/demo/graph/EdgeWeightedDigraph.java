package demo.graph;

import java.util.Scanner;

import demo.fundamental.*;

public class EdgeWeightedDigraph {
	private int V;
	private int E;
	private Bag<DirectedEdge>[] adj;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(Scanner scanner){
		V = scanner.nextInt();
		E = scanner.nextInt();
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for(int i = 0; i < V; i++)
			adj[i] = new Bag<DirectedEdge>();
		
		DirectedEdge diEdge;
		for(int i = 0; i < E; i++){
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			float weight = scanner.nextFloat();
			diEdge = new DirectedEdge(v, w, weight);
			addDirectedEdge(diEdge);
		}
	}
	
	public void addDirectedEdge(DirectedEdge edge){
		int v = edge.from();
		adj[v].add(edge);
	}
	
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for(int i = 0; i < V; i++)
			for(DirectedEdge e : adj[i])
				bag.add(e);
		return bag;
	}
}
