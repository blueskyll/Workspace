package demo;

/*
 * 加权quick-union算法，能保证像quick-union算法中深度无限制增加的情况不再出现
 * 将随意把一棵树连接到另一棵树的策略改变为总是将较小的树连接到较大的树上
 * @param sz记录每个连通量的深度
 */
public class WeightedQuickUnion {

	/**
	 * @param args
	 */
	private int count;
	private int[] id;
	private int[] sz;
	public WeightedQuickUnion(int n){
		count = n;
		id = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
		}
		
		sz = new int[n];
		for(int i = 0; i < n; i++){
			sz[i] = 1;
		}
	}
	
	public int find(int p){
		while(p != id[p]){
			p = id[p];
		}
		return id[p];
	}
	
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot) return;
		
		//将深度较小的树连接到深度较大的树上
		if(sz[pRoot] < sz[qRoot]){
			id[pRoot] = id[qRoot];
			sz[qRoot] += sz[pRoot];
		}
		else{
			id[qRoot] = id[pRoot];
			sz[pRoot] += sz[qRoot];
		}
		
		count--;
	}
	
	public boolean connect(int p, int q){
		return find(p) == find(q);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = StdIn.readInt();
		WeightedQuickUnion wqf = new WeightedQuickUnion(n);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(wqf.connect(p,q)) continue;
			wqf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(wqf.count + "components");
	}

}
