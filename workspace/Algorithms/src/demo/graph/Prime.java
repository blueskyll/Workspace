package demo.graph;

import demo.fundamental.*;
import demo.sort.MinPQ;
import java.util.Scanner;;

public class Prime {

	private Edge[] edge;
	private MinPQ<Edge> pq;
	private boolean[] state;
	private EdgeWeightedGraph G;
	private Queue<Edge> mst;
	
	public void solve(){
		read();
		getMST();
		print();
	}
	
	public void getMST(){
		visit(1);
		while(!pq.isEmpty()){
			Edge e= pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(state[v] && state[w])
				continue;
			mst.enqueue(e);
			if(!state[v])
				visit(v);
			else
				visit(w);
		}
	}
	
	public void visit(int node){
		state[node] = true;
		for(Edge e : G.adj(node)){
			if(!state[e.other(node)]) 
				pq.insert(e);
		}
	}
	
	public void read(){
		Scanner scanner = new Scanner(System.in);
		G = new EdgeWeightedGraph(scanner.nextInt());
		G.setE(scanner.nextInt());
		
		pq = new MinPQ<Edge>();
		mst = new Queue<Edge>();
		state = new boolean[G.V() + 1];
		edge = new Edge[G.E() + 1];
		
		for(int i = 1; i <= G.E(); i++){
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			float weight = scanner.nextFloat();
			edge[i] = new Edge(v, w, weight);
			G.addEdge(edge[i]);
		}
		scanner.close();
	}
	
	public void print(){
		while(!mst.isEmpty()){
			Edge e = mst.dequeue();
			System.out.println(e.either() + " -> " + e.other(e.either()) + " " + e.weight());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prime p = new Prime();
		p.solve();
	}

}
