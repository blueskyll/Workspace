package dp;

import java.util.Arrays;
import java.util.Scanner;

//treeset to make the elements of the array to be distinct and sorted
public class DPSequence {
	private long[] sequence;
	private long[] sortedSequence;
	private int sortedSeqLen;
	
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		int seqLen = scanner.nextInt();
		sequence = new long[seqLen];
		sortedSequence = new long[seqLen];
		
		for(int i = 0; i < seqLen; i++){
			sequence[i] = scanner.nextLong();
			if(!isValueExist(sequence[i], i))
				sortedSequence[sortedSeqLen++] = sequence[i];
		}
		scanner.close();
		Arrays.sort(sortedSequence, 0, sortedSeqLen);
		
		handleSequence();
	}
	
	public void handleSequence(){
		if(sequence.length == 1){
			System.out.println(0);
			return;
		}
		if(sequence.length == 2){
			if(sequence[1] > sequence[0]){
				System.out.println(0);
				return;	
			}
			System.out.println(Math.abs(sequence[1] - sequence[0]));
			return;
		}
		
		long[] lastRowOpCount = new long[sortedSeqLen];
		long[] cuRowOpCount = new long[sortedSeqLen];
		
		cuRowOpCount[0] = Math.abs(sequence[0] - sortedSequence[0]);
		for(int i = 1; i < sortedSeqLen; i++)
			cuRowOpCount[i] = Math.min(cuRowOpCount[i - 1], Math.abs(sequence[0] - sortedSequence[i]));
		
		int i = 1;
		while(i <= sequence.length - 1){
//			lastRowOpCount = cuRowOpCount;	
			int count = 0;
			for(long a : cuRowOpCount)
				lastRowOpCount[count++] = a;
			
			cuRowOpCount[0] = lastRowOpCount[0] + Math.abs(sequence[i] - sortedSequence[0]);
			for(int j = 1; j < sortedSeqLen; j++){
				cuRowOpCount[j] = Math.min(lastRowOpCount[j] + Math.abs(sequence[i] - sortedSequence[j]), cuRowOpCount[j - 1]);
			}//end for
			i++;
		}//end while
		System.out.println(cuRowOpCount[sortedSeqLen - 1]);
		
	}
	
	public boolean isValueExist(long x, int seqCount){
		for(int i = 0; i < seqCount; i++)
			if(x == sequence[i])
				return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DPSequence().solve();
	}

}
