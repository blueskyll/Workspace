package demo.graph;

public class TwoColor {
	private boolean[] color;
	private boolean[] marked;
	private boolean isTwoColorable;
	public TwoColor(Graph g){
		isTwoColorable = true;
		color = new boolean[g.V()];
		marked = new boolean[g.V()];
		for(int i = 0; i < g.V(); i++){
			if(!marked[i])
			{
				color[i] = true;
				dfs(g, i);
			}
				
		}
	}
	
	public void dfs(Graph g, int i){
		marked[i] = true;
		for(int w : g.adj(i)){
			if(!marked[w]){
				color[w] = !color[i];
				dfs(g, w);
			}
			else if(color[w] == color[i])
				isTwoColorable = false;
		}
	}
	
	public boolean isTwoColorable(){
		return isTwoColorable;
	}
}
