package demo;



public class QuickUnion {

	/**
	 * @param count �洢��ǰ��ͨ����
	 * @param id �Դ���Ϊ����������
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
	 * �ҵ����ڵ��idֵ
	 */
	public int find(int p){
		while(p != id[p]){
			p = id[p];
		}
		
		return id[p];
	}
	
	/*
	 * �ж��Ƿ���ͨ
	 */
	public boolean connect(int p, int q){
		return find(p) == find(q);
	}
	
	/*
	 * ���������ڵ�
	 */
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) return;
		
		//��һ��p�����ӵ�q����
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
