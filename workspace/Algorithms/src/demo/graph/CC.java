package demo.graph;

import demo.In;
import demo.fundamental.Bag;

//用深度优先搜索找出图的连通分量
public class CC {

	/**
	 * @param args
	 */
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph g){
		marked = new boolean[g.V()];
		id = new int[g.V()];
		for(int s = 0; s < g.V(); s++){
			if(!marked[s]){
				dfs(g, s);
				count++;
			}
		}
	}
	
	public void dfs(Graph g, int s){
		id[s] = count;
		marked[s] = true;
		for(int w : g.adj(s)){
			if(!marked[w]){
				marked[w] = true;
				dfs(g, w);
			}
		}
	}
	
	public boolean isConnected(int w, int v){
		return id[w] == id[v];
	}
	
	public int id(int v){
		return id[v];
	}
	
	public int count(){
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(new In(args[0]));
		CC c = new CC(g);
		Bag<Integer>[] bag = (Bag<Integer>[])new Bag[c.count()];
		for(int i = 0; i < c.count; i++){
			bag[i] = new Bag<Integer>();
			for(int j = 0; j < g.V(); j++){
				bag[c.id(j)].add(j);
			}
		}
	}

}
