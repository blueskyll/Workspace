package greedy;
import java.util.*;
public class Sum33C {
	private int num;
	private int[] seq;
	private int[] prefixSum;
	private int[] suffixSum;
	private int posNum;
	private int negNum;
	public void solve(){
		read();
		if(negNum != num && posNum != num){
			calPrefixSum();
			calSuffixSum();
			getMaxSum();
		}
		else{
			resultForSimpleInput();
		}
	}
	public void resultForSimpleInput(){
		int sum = 0;
		for(int i = 1; i <= num; i++)
			sum += seq[i];
		System.out.println(Math.abs(sum));
	}
	
	public void getMaxSum(){
		int maxSum = 0;
		
		for(int i = 1; i <= num; i++){
			for(int j = num; j >= i + 1; j--){
				int temp = Math.abs(prefixSum[i]) + prefixSum[j - 1] - prefixSum[i] + Math.abs(suffixSum[j]);
				maxSum = maxSum <  temp ? temp : maxSum;
			}//end for j
		}//end for i
		System.out.println(maxSum);
	}
	
	public void calPrefixSum(){
		prefixSum = new int[num  + 1];
		for(int i = 1; i <= num; i++)
			prefixSum[i] = prefixSum[i - 1] + seq[i];
	}
	
	public void calSuffixSum(){
		suffixSum = new int[num + 1];
		suffixSum[num] = seq[num];
		for(int i = num - 1; i >= 1; i--)
			suffixSum[i] = suffixSum[i + 1] + seq[i];
	}
	
	public void read(){
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		seq = new int[num + 1];
		for(int i = 1; i <= num; i++){
			seq[i] = scanner.nextInt();
			if(seq[i] <= 0)
				negNum++;
			if(seq[i] >= 0)
				posNum++;
		}
		scanner.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sum33C().solve();
	}

}
