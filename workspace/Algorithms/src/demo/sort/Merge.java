package demo.sort;

public class Merge {

	/**
	 * @param args
	 * 自顶向下的归并排序：分治思想
	 * 归并排序将两个有序的数组归并成一个更大的数组
	 * 归并排序的特点是能够保证将任意长度为N的数组排序所需时间和NlogN成正比
	 * 自顶向下的归并排序需要1/2NlgN至NlgN次比较
	 * 最多需要6NlgN次比较
	 */
	
	private static Comparable[] aux; //归并所需要的辅助数组
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int low, int hi){
		if(hi <= low) return;
		int mid = low + (hi - low)/2;
		sort(a, low, mid);
		sort(a, mid + 1, hi);
		merge(a, low, mid, hi);
	}
	
	
	/*
	 * 自底向上归并排序
	 * 
//	 * public static void sort(Comparable[] a, int low, int hi){
//		int N = a.length;
//		aux = new Comparable[N];
//		for(int sz = 1; sz < N; sz += sz){
//			for(int lo = 0; lo < N - sz; lo += sz + sz){
//				merge(a, lo, lo + sz -1, Math.min(lo + sz + sz - 1, N - 1));
//			}
//		}
//	}
	 *
	 */
	public static void merge(Comparable[] a, int low, int mid, int hi){
		int i = low, j = mid + 1;
		
		for(int k = low; k <= hi; k++)
			aux[k] = a[k];
		
		for(int k = low; k <= hi; k++){
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if(less(aux[j], aux[i])) 
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
				
		}
		
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings();
		sort(a);
	}

}
