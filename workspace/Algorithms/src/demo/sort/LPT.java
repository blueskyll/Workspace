package demo.sort;

import java.util.Arrays;

/*
 * 2.5.13 P238
 */
public class LPT<Key>{

	/**
	 * @param args
	 */
	int[][] priority;
//	String[] name;
	int N;
	public LPT(int capacity){
		priority = new int[capacity + 1][2];
		N = 0;
	}
	
	public void insert(int index, int prior, int t){
		priority[++N][0] = index;
		priority[N][1] =prior + t;
		if(t != 0){
			System.out.println("the task that need " + t + " time is assigned to processor" + " " + index);
			swim(N);
		}
	}
	public void swim(int n){
		while(n > 1 && less(n, n/2)){
			exch(n, n/2);
			n = n/2;
		}
	}
	
	public void exch(int i, int j){
		int[] temp = priority[i];
		priority[i] = priority[j];
		priority[j] = temp;
	}
	
	public void sink(int i){
		while(i * 2 <= N){
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
	
	public boolean less(int i, int j){
		return ((Comparable)priority[i][1]).compareTo(priority[j][1]) < 0;
	}
	
	public int[] delMin(){
		if(N == 0)
			return null;
		int[] temp = new int[2];
		System.arraycopy(priority[1], 0, temp, 0, 2);
		exch(1, N--);
		sink(1);
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 5;
//		String[] strM = new String[M];
//		for(int i = 1; i <= M; i++)
//			strM[i-1] = "M" + i;
		int[] N = {1, 3, 4, 2, 5, 6, 8, 9, 1};
		Arrays.sort(N);
		LPT<String> lpt = new LPT<String>(5);
		for(int i = 0; i < M; i++)
			lpt.insert(i + 1, 0, 0);
		for(int i = N.length - 1; i >= 0; i--){
			int[] delP = lpt.delMin();
			
			lpt.insert(delP[0], delP[1], N[i]);
		}
	}

}
