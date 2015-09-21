package demo.graph;

public class Bridge {
	private int bridges;
	private int count;
	private int[] pre;
	private int[] low;
	
	public Bridge(Graph G){
		pre = new int[G.V()];
		low = new int[G.V()];
		
		for(int i = 0; i < G.V(); i++){
			pre[i] = -1;
			low[i] = -1;
		}
		
		for(int v = 0; v < G.V(); v++){
			if(pre[v] == -1){
				dfs(G, v, v);
			}
		}
		
		for(int i = 0; i < G.V(); i++)
			System.out.println(low[i]);
	}
	
	public void dfs(Graph G, int u, int v){
		pre[v] = count++;
		low[v] = pre[v];
		System.out.println(v + " ->" + low[v]);
		for(int w : G.adj(v)){
			if(pre[w] == -1){
				dfs(G, v, w);
				low[v] = Math.min(low[v], low[w]);
				if (low[w] == pre[w]) {
                    System.out.println(v + "-" + w + " is a bridge");
                    bridges++;
                }
			}
			else if(w != u)
				low[v] = Math.min(low[v], pre[w]);
		}
	}
	
	public static void main(String[] args){
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 3);
		new Bridge(g);
	}
}
