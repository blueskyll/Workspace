package demo.sort;

public class Merge {

	/**
	 * @param args
	 * �Զ����µĹ鲢���򣺷���˼��
	 * �鲢�����������������鲢��һ�����������
	 * �鲢������ص����ܹ���֤�����ⳤ��ΪN��������������ʱ���NlogN������
	 * �Զ����µĹ鲢������Ҫ1/2NlgN��NlgN�αȽ�
	 * �����Ҫ6NlgN�αȽ�
	 */
	
	private static Comparable[] aux; //�鲢����Ҫ�ĸ�������
	
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
	 * �Ե����Ϲ鲢����
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
