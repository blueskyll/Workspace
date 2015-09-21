package demo;



public class QuickUnion {

	/**
	 * @param count 存储当前连通个数
	 * @param id 以触点为索引的数组
	 */
	private int count;
	private int[] id;
	public QuickUnion(int n){
		count = n;
		id = new int[n];
		for(int i = 0; i< n; i++){
			id[i] = i;
		}
	}
	
	/*
	 * 找到根节点的id值
	 */
	public int find(int p){
		while(p != id[p]){
			p = id[p];
		}
		
		return id[p];
	}
	
	/*
	 * 判断是否连通
	 */
	public boolean connect(int p, int q){
		return find(p) == find(q);
	}
	
	/*
	 * 连接两个节点
	 */
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) return;
		
		//将一个p树连接到q树上
		id[pRoot] = qRoot;
		
		count--;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = StdIn.readInt();
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			QuickUnion qu = new QuickUnion(n);
			if(qu.connect(p, q)) continue;
			qu.union(p, q);
		}
	}

}
