package demo.sort;

/*
 * 2.3.22
 */
public class QuickThree {

	//等于要交换没有实现
	
	public static void sort(int[] a, int low, int hi){
		if(low >= hi)
			return;
		int p = low, i = low, j = hi, q = hi;
		int flag = a[low];
		i = i + 1;
		p = i;
	
		while(i <= j){
			while(i <= j && a[i] == flag){
				int temp = a[i];
				a[i] = a[p];
				a[p] = temp;
				p++;
				i++;//等于要交换没有实现
			}
			while(i <= j && a[j] == flag){
				int temp = a[q];
				a[q] = a[j];
				a[j] = temp;
				q--;
				j--;//等于要交换没有实现
			}
			if(i < j && a[i] > flag && a[j] < flag){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
			else if(i < j && a[i] > flag){
				while(a[j] > flag && i < j)
					j--;
				if(i != j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				
			}
			else if(i < j && a[j] < flag){
				while(a[i] < flag && i < j)
					i++;
				if(i != j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				
			}
			else if(i == j){
				if(a[i] < flag){
					i++;
				}
				else{
					j--;
				}
			}
			else if(i < j){
				i++;
				j--;
			}
		}//end for while
		prointF(a);
		System.out.println(p + "f" + q + "f" + i + "f" + j);
		int index1 = low + i - p - 1;
		int index2 = hi - q + j + 1;
		System.out.println(p + "f" + q + "f" + i + "f" + j);
		for(int x = low; j >= p && x < p; x++, j--)
		{
			int temp = a[x];
			a[x] = a[j];
			a[j] = temp;
		}
		for(int x = hi; i <= q && x > q; x--, i++){
			int temp = a[x];
			a[x] = a[i];
			a[i] = temp;	
		}
		prointF(a);
		System.out.println(p + "f" + q + "f" + i + "f" + j);
		sort(a, low, index1);
		sort(a, index2, hi);
	}
	
	public static void sort(int[] a){
		sort(a, 0, a.length - 1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9,9,1,0,3,2,1,3,0,5,4,1,0,1,8,2,1,6,7,6,9,1,2,4,6,3,6,8,9,9,8,0};
		sort(a);
	
	}
	
	public static void prointF(int[] a)
	{
		for(int i = 0; i < a.length; i ++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

}

