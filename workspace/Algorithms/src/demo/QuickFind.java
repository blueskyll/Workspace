package demo;

/*
 * 当且仅当id[p]等于id[q]时p和q是连通的
 * 该算法无法处理大型问题，对于每对输入都需要扫描整个id数组
 * 其中union操作访问数组的次数在（N+3）到（2N+1）之间
 */

public class QuickFind {

	/**
	 * @param args
	 */
	
	private int count;
	private int[] id;
	
	public QuickFind(int n){
		count = n;
		id = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
		}
	}
	
	public boolean connect(int p, int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		return id[p];
	}
	
	public void union(int p, int q){
		int pId = find(p);
		int qId = find(q);
		for(int i = 0; i< id.length; i++){
			if(id[i] == pId){
				id[i] = qId;
			}
		}
		count--;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = StdIn.readInt();
		QuickFind qf = new QuickFind(n);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(qf.connect(p,q)) continue;
			qf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(qf.count + "components");
	}

}
