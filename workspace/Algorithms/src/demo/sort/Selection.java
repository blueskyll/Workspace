package demo.sort;

import demo.sort.In;
import demo.sort.StdOut;

public class Selection {

	/**
	 * @param args
	 * ѡ������Գ�ΪN�����飬��ԼҪ����N^2/2�αȽϺ�N�ν���
	 * ʱ��Ч��ȡ���ڱȽϴ���
	 */
	
	public static void sort(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i + 1; j < a.length; j++){
				if(less(a[j], a[min])) 
					min = j;
			}
			exch(a, i, min);
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
