package dp;

import java.util.Scanner;

public class Sequence {
	long[] operationCount;
	
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		int seqLen = scanner.nextInt();
		long[] sequence = new long[seqLen];
		for(int i = 0; i < seqLen; i++)
			sequence[i] = scanner.nextLong();
		scanner.close();
		
		handleSequence(sequence, seqLen);
	}
	
	public void handleSequence(long[] sequence, int seqLen){
		if(seqLen == 1){
			System.out.println(0);
			return;
		}
		if(seqLen == 2){
			System.out.println(Math.abs(sequence[1] - Math.abs(sequence[0])));
			return;
		}
		operationCount = new long[seqLen];
		
		//record the value that may be changed 
		long[] modifiedValue = new long[seqLen];
		modifiedValue[seqLen - 1] = sequence[seqLen - 1];
		modifiedValue[0] = sequence[0];
		for(int i = seqLen - 2; i >= 1; i--){
			modifiedValue[i] = sequence[i];
		}
		
		int i = seqLen - 2;
	
		if(sequence[i + 1] < sequence[i]){
			modifiedValue[i] = sequence[i + 1];
			modifiedValue[i + 1] = sequence[i];
			operationCount[i + 1] = Math.abs(sequence[i + 1] - sequence[i]);
		}

		
		//compare the i-th value with the (i-1)th value
		while(i >= 1){
			int flag = 0; 
			long secondFactor1 = modifiedValue[i], firstFactor = sequence[i - 1];
			long distance1 = secondFactor1 - firstFactor;
			
			long secondFactor2 = sequence[i];
			long distance2 = secondFactor2 - firstFactor;
			
			if(distance1 >= 0 && distance2 >= 0){
				operationCount[i] = operationCount[i + 1];
			}
			else{
				if(Math.abs(distance1) < Math.abs(distance2)){
					operationCount[i] = operationCount[i + 1] + Math.abs(distance1); 
					modifiedValue[i - 1] = modifiedValue[i];
				}
				else{
					operationCount[i] = operationCount[i + 1] +  Math.abs(distance2);
					modifiedValue[i - 1] = sequence[i];
					modifiedValue[i] = sequence[i - 1];
				}
				
			}//end else
			i--;
		}//end while
		System.out.println(operationCount[1]);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sequence().solve();
	}

}
