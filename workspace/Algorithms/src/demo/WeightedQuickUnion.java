package demo;

/*
 * ��Ȩquick-union�㷨���ܱ�֤��quick-union�㷨��������������ӵ�������ٳ���
 * �������һ�������ӵ���һ�����Ĳ��Ըı�Ϊ���ǽ���С�������ӵ��ϴ������
 * @param sz��¼ÿ����ͨ�������
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
		
		//����Ƚ�С�������ӵ���Ƚϴ������
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
