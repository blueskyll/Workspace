package demo.sort;

public class Shell {

	/**
	 * @param args
	 * 希尔排序是基于插入排序的快速排序算法；使数组中任意间隔是h的元素都是有序的
	 * 性能：运行时间达不到平方级别；最坏情况下其比较次数与N的二分之三次方成正比；
	 */
	
	public static void sort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		while(h >= 1){
			for(int i = h; i < N; i++){
				for(int j = i; j >= h && less(a[j], a[j-h]); j-=h){
					exch(a, j, j-h);
				}
				h = h/3;
			}
		}
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + " ");
			StdOut.println();
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings();
		sort(a);
		isSorted(a);
		show(a);
	}

}
