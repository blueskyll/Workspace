package demo.graph;

/**
 * 4.1.13
 */
import demo.fundamental.Queue;
import demo.fundamental.Stack;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private final int s;
	
	public BreadthFirstPaths(Graph g, int s){
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		distTo = new int[g.V()];
		distTo[s] = 0;
		bfs(g, s);
	}
	
	public void bfs(Graph g, int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()){
			int v = queue.dequeue();
			for(int w : g.adj(v)){
				if(!marked[w]){
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					edgeTo[w] = v;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public int distTo(Graph g, int v){
		if(hasPathTo(v)){
			return distTo[v];
		}
		return Integer.MAX_VALUE;
	}
	
	public Iterable<Integer> pathTo(int v){
		if(hasPathTo(v)){
			Stack<Integer> stack = new Stack<Integer>();
			while(v != s){
				stack.push(v);
				v = edgeTo[v];
			}
			stack.push(s);
			return stack;
		}
		return null;
	}
	
	
}
