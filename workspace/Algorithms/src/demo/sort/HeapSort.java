package demo.sort;

/*
 * �����������ŵ�����ʱ��Ϳռ䣬�����޷����û��棨����Ԫ�غ��ٺͺ����ڵ�Ԫ�����Ƚϣ������ʹ�ò����㷺
 * ���ȶ���
 */
public class HeapSort {

	/**
	 * @param args
	 */
	
	public static void heapSort(int[] array){
		buildHeap(array); // ���������
		int n = array.length;
		int i = 0;
		for(i = n - 1; i >= 1;i--){ //�Զѽ�������
			swap(array, 0 ,i);
			sink(array, 0, i);
		}
	}
	
	public static void buildHeap(int[] array){
		int n = array.length;
		for(int i = n/2 - 1; i >= 0; i--)
		{
			sink(array, i , n);
		}
	}
	
	public static void sink(int[] array, int node, int n){
		int left = 2 * node + 1;
		int right = 2 * node + 2;
		int largest = 0;
		if(left < n && array[left] > array[node]){
			largest = left;
		}
		else{
			largest = node;
		}
		
		if(right < n && array[right] > array[largest]){
			largest = right;
		}
		
		if(largest != node){
			swap(array, largest, node);
			sink(array, largest, n);
		}
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,16,9,10,11,1,12,13,8,14,15};
		System.out.println("����ǰ..........................");
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
		System.out.println();
		heapSort(a);
		
		System.out.println("�����..........................");
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
	}

}
