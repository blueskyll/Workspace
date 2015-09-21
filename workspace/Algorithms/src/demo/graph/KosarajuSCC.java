package demo.graph;

/*
 * 计算强联通分量
 */
public class KosarajuSCC {

	/**
	 * @param args
	 */
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public KosarajuSCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		
		for(int s : order.reversePost()){
			if(!marked[s])
			{
				dfs(G, s);
				count++;
			}
		}
	}
	
	public void dfs(Digraph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	public boolean stronglyConnected(int w, int v){
		return id[w] == id[v];
	}
	
	public int count(){
		return count;
	}
	
	public int id(int v){
		return id[v];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
