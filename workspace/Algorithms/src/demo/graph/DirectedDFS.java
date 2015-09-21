package demo.graph;

public class DirectedDFS {
	private boolean[] marked;
	
	public DirectedDFS(Digraph g, int v){
		marked = new boolean[g.V()];
		dfs(g, v);
	}
	
	public DirectedDFS(Digraph g, Iterable<Integer> sources){
		marked = new boolean[g.V()];
		for(int w : sources)
			if(!marked[w])
				dfs(g, w);
	}
	
	public void dfs(Digraph g, int v){
		marked[v] = true;
		for(int w : g.adj(v)){
			if(!marked[w])
				dfs(g, w);
		}
	}
	
	public boolean marked(int v){
		return marked[v];
	}
}
