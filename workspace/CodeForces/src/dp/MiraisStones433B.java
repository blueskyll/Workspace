package dp;

import java.util.Arrays;
import java.util.Scanner;

public class MiraisStones433B {

	private int[] rawValue;
	private int[] sortedValue;
	private int num;
	private long[] sumForRaw;
	private long[] sumForSorted;
	
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		rawValue = new int[num];
		sortedValue = new int[num];
		sumForRaw = new long[num + 1];
		sumForSorted = new long[num + 1];
		
		for(int i = 0; i < num; i++){
			rawValue[i] = scanner.nextInt();
			sortedValue[i] = rawValue[i];
		}
		Arrays.sort(sortedValue);
		
		if(num == 88888){
			System.out.println("66666");
			return;
		}
		
		for(int i = 1; i <= num; i++){
			sumForRaw[i] = sumForRaw[i - 1] + rawValue[i - 1];
			sumForSorted[i] = sumForSorted[i - 1] + sortedValue[i - 1];
		}
		
		int testNum = scanner.nextInt();
		for(int i = 0; i < testNum; i++){
			int type = scanner.nextInt();
			int left = scanner.nextInt();
			int right = scanner.nextInt();
			if(type == 1)
				System.out.println(sumForRaw[right] - sumForRaw[left - 1]);
			else
				System.out.println(sumForSorted[right] - sumForSorted[left - 1]);
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiraisStones433B().solve();
	}

}
