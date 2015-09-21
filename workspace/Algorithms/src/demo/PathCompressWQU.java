package demo;

public class PathCompressWQU {

	/**
	 * @param args
	 */
	private int count;
	private int[] id;
	private int[] sz;
	
	public PathCompressWQU(int n){
		count = n;
		id = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] =  1;
		}
	}
	
	public int find(int p){
		int temp = p;
		while(p != id[p]){
			p = id[p];
		}
		
		while(temp != id[p]){
			int tempId = id[temp];
			id[temp] = id[p];
			temp = tempId;
		}
		
		return id[p];
	}
	
	public boolean connect(int p, int q){
		return find(p) == find(q);
	}
	
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot) return;
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = StdIn.readInt();

		PathCompressWQU pcwqu = new PathCompressWQU(n);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(pcwqu.connect(p, q)) continue;
			
			pcwqu.union(p, q);
			
			StdOut.println(p + " " + q);
 		}
		
		StdOut.println(pcwqu.count + "components");
	}

}
