package demo;
import java.util.Arrays;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while(!StdIn.isEmpty())
		{
			int key = StdIn.readInt();
			if(rank(key,whitelist)<0)
				StdOut.println(key);
		}
	}
	
	public static int rank(int key, int []a){
		int low = 0;
		int high = a.length - 1;
		int mid = (high - low) / 2 + low;
		
		while(low <= high)
		{
			if(key < a[mid])
			{
				high = mid - 1;
			}
			else if(key > a[mid])
			{
				low = mid + 1;
			}
			else
			{
				return 1;
			}
		}
		
		return -1;
	}

}
