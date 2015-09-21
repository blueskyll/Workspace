package demo.sort;

public class IndexMerge {

	/**
	 * 2.2.20
	 * @param args
	 */
	public static int[] sort(int[] a){
		int[] index = new int[a.length];
		int[] aux = new int[a.length];
		for(int i = 0; i < index.length; i++)
			index[i] = i;
		sort(a, index, aux, 0, a.length - 1);
		return index;
	}
	
	public static void sort(int[] a, int[] index, int[] aux, int low, int hi){
		if(low >= hi)
			return;
		int mid = low + (hi - low)/2;
		sort(a, index, aux, low, mid);
		sort(a, index, aux, mid + 1, hi);
		merge(a, index, aux, low, mid, hi);
	}
	
	public static void merge(int[] a, int[] index, int[] aux, int low, int mid, int hi){
		for(int k = low; k <= hi; k++)
			aux[k] = index[k];
		int i = low, j = mid + 1;
		for(int k = low; k <= hi; k++){
			if(i > mid){
				index[k] = aux[j++];
			}
			else if(j > hi)
				index[k] = aux[i++];
			else if(a[index[j]] < a[index[i]])
				index[k] = aux[j++];
			else
				index[k] = aux[i++];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 1, 1, 0, 1, 4, 0};
		int index[] = sort(a);
		for(int i = 0; i < index.length; i++)
			System.out.print(index[i] + " ");
	}

}
