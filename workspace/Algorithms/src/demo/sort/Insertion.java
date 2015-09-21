package demo.sort;

public class Insertion {

	/**
	 * @param args
	 * ƽ��N^2/4�αȽϺ�N^2/4�ν�����������N^2/2�αȽ��Լ�N^2/2�ν��������N-1�αȽ��Լ�0�ν�����
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
