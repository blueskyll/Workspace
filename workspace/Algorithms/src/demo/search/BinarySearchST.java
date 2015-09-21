package demo.search;

public class BinarySearchST<Key extends Comparable<Key>, Value>{

	/**
	 * @param args
	 */
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity){
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public Value get(Key key){
		if(isEmpty())
			return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else return null;
	}
	
	public void put(Key key, Value val){
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0){
			vals[i] = val;
		}
		else{
			for(int j = N; j > i; j--)
			{
				keys[j] = keys[j - 1];
				vals[j] = vals[j - 1];
			}
			keys[i] = key;
			vals[i] =val;
			N++;
		}
	}
	
	public void delete(Key key){
		if(isEmpty())
			return;
		int index = rank(key);
		if(index < N && keys[index].compareTo(key) == 0){
			for(int i = index; i < N - 1; i++){
				keys[i] = keys[i + 1];
				vals[i] = vals[i + 1];
			}
			N--;
			keys[N] = null;
			vals[N] = null;
		}
	}
	
	public Key floor(Key key){
		if(isEmpty())
			return null;
		int index = rank(key);
		if(index < N && keys[index].compareTo(key) == 0){
			return keys[index];
		}
		return keys[index - 1];
	}
	
	public int rank(Key key){
		int lo = 0, hi = N - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			int cmp = keys[mid].compareTo(key);
			if(cmp < 0)
				lo = mid + 1;
			else if(cmp > 0)
				hi = mid - 1;
			else
				return mid;
		}
		return lo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
