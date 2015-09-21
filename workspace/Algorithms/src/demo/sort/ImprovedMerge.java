package demo.sort;

/*
 * 2.2.9
 */
public class ImprovedMerge {

	/**
	 * @param args
	 */
	
	public static void merge(int[] a, int[] aux, int low, int mid, int hi){
		for(int i = low; i <= hi; i++){
			aux[i] = a[i];
		}
		
		int i = low, j = mid + 1;
		for(int k = low; k <= hi; k++){
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if(aux[j] < aux[i])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	
	public static void sort(int[] a, int[] aux, int low, int hi){
		
		if( low >= hi)
			return;
		int mid = low + (hi - low)/2;
		sort(a, aux, low, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, low, mid, hi);
	}
	
	public static void sort(int[] a){
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	public static void merge(int[] a, int low, int hi){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,1,8,123,455,67,12};
		sort(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}

}
