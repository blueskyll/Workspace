package demo.sort;

/*
 * 2.4.33
 */
public class IndexMaxPQ<Key extends Comparable<Key>>{

	private int N; //amount of elements
	private int[] pq;//index two-fork heap, start from 1
	private int[] qp;//reverse of pq: qp[pq[i]] = i
	private Key[] keys;
	
	public IndexMaxPQ(int maxN){
		keys = (Key[])new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for(int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public boolean contains(int k){
		return qp[k] != -1;
	}
	
	public void insert(int k, Key key){
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}
	
	public void swim(int n){
		while(n > 1 && less(n/2, n)){
			exch(n/2, n);
			n = n/2;
		}
	}
	
	public boolean less(int i, int j){
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}
	public void exch(int i, int j){
		int temp = qp[pq[i]];
		qp[pq[i]] = qp[pq[j]];
		qp[pq[j]] = temp;
		int temp1 = pq[i];
		pq[i] = pq[j];
		pq[j] = temp1;
	}
	
	public Key max(){
		return keys[pq[1]];
	}
	
	public int delMax(){
		int indexOfMax = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N + 1]] = null;
		qp[pq[N + 1]] = -1;
		return indexOfMax;
	}
	
	public void sink(int i){
		while(i * 2 <= N){
			int k = i * 2;
			if(k < N && less(k, k + 1))
				k++;
			if(!less(i, k))
				break;
			exch(i, k);
			i = k;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IndexMaxPQ<String> test = new IndexMaxPQ<String>(5);
		test.insert(0, "2222");
		test.insert(1, "111");
		test.insert(2, "1111");
		for(int i = 0; i < 3; i++)
			System.out.println(test.max() + " " + test.delMax());
	}

}
