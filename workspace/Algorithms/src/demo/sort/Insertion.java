package demo.sort;

public class Insertion {

	/**
	 * @param args
	 * 平均N^2/4次比较合N^2/4次交换；最坏情况下N^2/2次比较以及N^2/2次交换；最好N-1次比较以及0次交换；
	 */
	
	public static void sort(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
				exch(a, j ,j - 1);
			}
		}
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
