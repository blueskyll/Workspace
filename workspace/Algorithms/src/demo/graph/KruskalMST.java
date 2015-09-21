package demo.graph;

import java.util.Iterator;
import java.util.Scanner;

import demo.QuickUnion;
import demo.fundamental.Queue;
import demo.sort.MinPQ;
public class KruskalMST {

	private EdgeWeightedGraph G;
	private MinPQ<Edge> pq;
	private Queue<Edge> mst;
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		G = new EdgeWeightedGraph(scanner.nextInt());
		G.initialize(scanner);
		pq = new MinPQ<Edge>(G.V() - 1);
		mst = new Queue<Edge>();
		
		for(Edge e : G.edges())
			pq.insert(e);
		
		QuickUnion qu = new QuickUnion(G.V());
		while(!pq.isEmpty() && mst.size() < G.V() - 1){
			Edge e = pq.delMin();
			int w = e.either();
			int v = e.other(w);
			if(qu.connect(w, v)) continue;
			qu.union(w, v);
			mst.enqueue(e);
		}
		
		System.out.println(weight());
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public float weight(){
		float sum = 0L;
		Iterator<Edge> mstIter = mst.iterator();
		while(mstIter.hasNext()){
			Edge temp = mstIter.next();
			sum += temp.weight();
			int v = temp.either();
			System.out.println(v + "->" + temp.other(v) + ": " + temp.weight());
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KruskalMST().solve();
	}

}
