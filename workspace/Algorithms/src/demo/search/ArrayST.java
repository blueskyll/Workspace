package demo.search;

import demo.fundamental.Queue;

public class ArrayST<Key, Value> {

	/**
	 * @param args
	 */
	private Value[] vals;
	private Key[] keys;
	private int N = 0;
	
	public ArrayST(int INIT_SIZE){
		keys = (Key[]) new Object[INIT_SIZE];
		vals = (Value[]) new Object[INIT_SIZE];
		
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	private void resize(int capacity){
		Key[] tempK = (Key[]) new Object[capacity];
		Value[] tempV = (Value[]) new Object[capacity];
		for(int i = 0; i < N; i++){
			tempK[i] = keys[i];
			tempV[i] = vals[i];
		}
		keys = tempK;
		vals = tempV;
	}
	public void put(Key key, Value val){
		delete(key);
		if(N >= vals.length)
			resize(2 * N);
		vals[N] = val;
		keys[N] = key;
		N++;
	}
	
	public boolean contains(Key key){
		for(int i = 0; i < N; i++)
			if(keys[i].equals(key))
				return true;
		return false;
	}
	public Value get(Key key){
		for(int i = 0; i < N; i++){
			if(keys[i].equals(key)){
				return vals[i];
			}
		}// end for
		return null;
	}
	
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
		for(int i = 0; i <N; i++)
			queue.enqueue(keys[i]);
		return queue;
	}
	
	public void delete(Key key){
		for(int i = 0; i < N; i++){
			if(keys[i].equals(key)){
				keys[i] = keys[N - 1];
				vals[i] = vals[N - 1];
				vals[N - 1] = null;
				keys[N - 1] = null;
				N--;
				if(N > 0 && N == keys.length / 4)
					resize(N / 2);
				return;
			}//end if
		}//end for
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
