package demo.graph;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph g){
		hasCycle = false;
		marked = new boolean[g.V()];
		for(int i = 0; i < g.V(); i++){
			if(!marked[i]){
				dfs(g, i, i);
			}
		}
	}
	
	/*
	 * u表示v的前一个节点，若v的邻接节点w被标记且不是u结点时，则代表有环
	 */
	public void dfs(Graph g, int v, int u){
		marked[v] = true;
		for(int w : g.adj(v)){
			if(!marked[w]){
				dfs(g, w, v);
			}
			else if(w != u)
				hasCycle = true;
		}
	}
	
	public boolean isCycle(){
		return hasCycle;
	}
}
