package demo.sort;

/*
 * 2.5.12 P228
 */
public class SPT <Key>{

	private Key[] pq;
	private int N;
	private String[] name;
	
	SPT(){
		pq = (Key[])new Object[2];
		name = new String[2];
		N = 0;
	}
	
	public void resize(int length){
		Key[] temp = (Key[])new Object[length];
		String[] tempName = new String[length];
		for(int i = 1; i <= N; i++){
			temp[i] = pq[i];
			tempName[i] = name[i];
		}
		pq = temp;
		name = tempName;
	}
	
	public boolean less(int i, int j){
		return ((Comparable)pq[i]).compareTo(pq[j]) < 0;
	}
	
	public void exch(int i, int j){
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		String tempName = name[i];
		name[i] = name[j];
		name[j] = tempName;
	}
	public void swim(int n){
		while(n > 1 && less(n, n/2)){
			exch(n, n/2);
			n = n/2;
		}
	}
	
	public void insert(Key k, String str){
		if(N >= pq.length - 1)
			resize(pq.length * 2);
		pq[++N] = k;
		name[N] = str;
		swim(N);
	}
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void sink(int i){
		while(2 * i <= N){
			int k = i * 2;
			if(k < N && less(k + 1, k))
				k++;
			if(less(k, i))
			{
				exch(k, i);
				i = k;
			}
			else
				break;
		}
	}
	public String delMin(){
		if(isEmpty())
			return null;
		Key value = pq[1];
		String name1 = name[1];
		exch(1, N--);
		sink(1);
		pq[N + 1] = null;
		String s = value + " " + name1;
		return s;
	}
	
	public int getLength(){
		return N;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SPT<Integer> m = new SPT<Integer>();
		m.insert(1, "a");
		m.insert(3, "c");
		m.insert(2, "b");
		int length = m.getLength();
		for(int i = 0; i < length; i++)
			System.out.println(m.delMin());
	}

}
