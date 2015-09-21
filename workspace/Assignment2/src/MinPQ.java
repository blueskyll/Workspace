

public class MinPQ<Key>{

	private Key[] pq;
	private int N;
	
	/**
	 * @param args
	 */
	
	public MinPQ(){
		pq = (Key[]) new Object[2];
		N = 0;
	}
	
	public MinPQ(int capacity){
		pq = (Key[])new Object[capacity + 1];
		N = 0;
	}
	
	public void resize(int n){
		Key[] temp = (Key[]) new Object[n];
		for(int i = 1; i <= N; i++)
			temp[i] = pq[i];
		pq = temp;
	}

	public Key max(){
		if(N >= 1)
			return pq[1];
		else
			return null;
	}
	public void insert(Key item) {
		// TODO Auto-generated method stub
		if(N >= pq.length -1)
			resize(2 * pq.length);
		pq[++N] =item; //数组从1开始
		swim(N);
//		boolean b = isMaxHeap();
	}

	public void swim(int n) {
		// TODO Auto-generated method stub
		while(n > 1 && less(pq[n / 2], pq[n])){
			exch(n, n/2);
			n = n / 2;
		}
	}

	public void exch(int n2, int i) {
		// TODO Auto-generated method stub
		Key temp = pq[n2];
		pq[n2] = pq[i];
		pq[i] = temp;
	}

	public boolean less(Key key, Key key2) {
		// TODO Auto-generated method stub
		return ((Comparable) key).compareTo(key2) > 0;
	}
	
	
	

	public Key delMin() {
		// TODO Auto-generated method stub
		if(isEmpty())
			System.out.println("empty");
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N + 1] = null;
		if((N > 0) && (N == (pq.length - 1) / 4)) 
		resize(pq.length / 2);
		return max;
	}

	public boolean isMaxHeap(){
		return isMaxHeap(1);
	}
	public boolean isMaxHeap(int k){
		if(k > N)
			return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if(left <= N && less(pq[k], pq[left]))
			return false;
		if(right <= N && less(pq[k], pq[right]))
				return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}
	
	public void sink(int i) {
		// TODO Auto-generated method stub
		while(2 * i <= N){
			int j = 2 * i;
			if(j < N && less(pq[j], pq[j + 1]))
				j++;
			if(!less(pq[i], pq[j]))
				break;
			exch(i, j);
			i = j;
		}
			
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return N == 0;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MinPQ<String> pq = new MinPQ<String>();
//		
//		String[] str = {"0", "1", "2", "3", "-", "-", "-", "-"};
//		int length = str.length - 1;
//		int i = 0;
//		while(i <= length){
//			String item = str[i];
//			if(!item.equals("-"))
//				pq.insert(item);
//			else if(!pq.isEmpty())
//				System.out.println(pq.delMin());
//			i++;
//		}
//	}


}
