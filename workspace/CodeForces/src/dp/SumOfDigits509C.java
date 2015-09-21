package dp;

import java.math.BigInteger;
import java.util.Scanner;

public class SumOfDigits509C {

	private int num;
	private int[] sumOfRaw;
	private BigInteger[] raw;
	
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		sumOfRaw = new int[num + 1];
		raw = new BigInteger[num + 1];
		for(int i = 1; i <= num; i++)
			sumOfRaw[i] = scanner.nextInt();
		scanner.close();
		
		raw[0] = BigInteger.ZERO;
		restoreSeq();
		print();
	}
	
	public void print(){
		for(int i = 1; i <= num; i++)
			System.out.println(raw[i]);
	}
	public void restoreSeq(){
		for(int i = 1; i <= num; i++)
			switchNum(i);
	}
	
	public void switchNum(int i){
		BigInteger tempRaw = raw[i - 1].add(BigInteger.ONE);
		while(true){
			int temp = sumOfDigit(tempRaw);
			if(temp == sumOfRaw[i]){
				raw[i] = tempRaw;
				break;
			}
			BigInteger b = new BigInteger(sumOfRaw[i] +"");
			if(b.compareTo(tempRaw) > 0){
				greater(temp, i, tempRaw);
				break;
			}
			else{//<
				less(temp, i, tempRaw);
				break;
			}
		}
	}
	
	public void less(int temp, int i, BigInteger tempRaw) {
		String strTempRaw = tempRaw.toString();
		int length = strTempRaw.length();

		while (sumOfDigit(tempRaw) != sumOfRaw[i]) {
			if(Math.ceil((double)sumOfRaw[i] / 9) > length){
				tempRaw = BigInteger.TEN.pow((int)(Math.ceil((double)sumOfRaw[i] / 9) - 1));
				length = (int) Math.ceil((double)sumOfRaw[i] / 9);
			}
			BigInteger b = BigInteger.TEN.pow(length - 1);
			if (sumOfDigit(tempRaw.divide(b)) >= sumOfRaw[i]) {
				tempRaw = BigInteger.TEN.pow(length++);
			}
			else if(sumOfDigit(tempRaw.divide(b)) < sumOfRaw[i] && sumOfDigit(tempRaw) > sumOfRaw[i]){
				int tempSum = 0;
				int tempLength = length;
				BigInteger tTempRaw = tempRaw;
				while(tempSum < sumOfRaw[i]){
					BigInteger t= BigInteger.TEN.pow(tempLength - 1);
					tempSum += tTempRaw.divide(t).intValue();
					tTempRaw = tTempRaw.subtract(tTempRaw.divide(t).multiply(t));
					tempLength--;
				}
				int index = length - tempLength - 2;
				BigInteger t1 = BigInteger.TEN.pow(length - index - 1);
				tempRaw = tempRaw.divide(t1).multiply(t1).add(t1);
			
			}
			else if(sumOfDigit(tempRaw) < sumOfRaw[i]){
				for(int w = 1; ;w++){
					BigInteger t2 = BigInteger.TEN.pow(w);
					if (sumOfRaw[i] - sumOfDigit(tempRaw.divide(t2)) < 9 * w) {
//						String s = Long.toString(tempRaw / (int) Math.pow(10, w));
						String s = "";
						for (int k = 0; k < w - 1; k++)
							s = 9 + s;
						s = sumOfRaw[i] - (w - 1) * 9 - sumOfDigit(tempRaw.divide(t2))+ s;
						tempRaw = new BigInteger(tempRaw.divide(t2) + s);
						break;
					} // end if
				}
			}
			if(sumOfDigit(tempRaw) == sumOfRaw[i]){
				break;
			}
			tempRaw = tempRaw.add(BigInteger.ONE);
		}//end while
		raw[i] = tempRaw;
	}
	
	public void greater(int temp, int i, BigInteger tempRaw){
		if(sumOfRaw[i] <= 9 && tempRaw.compareTo(new BigInteger("9")) <= 0){
			raw[i] = new BigInteger(sumOfRaw[i] + "");
			return;
		}
		for (int j = 1; ;j++) {
			BigInteger b = BigInteger.TEN.pow(j);
			if (sumOfRaw[i] - sumOfDigit((tempRaw.divide(b))) < 9 * j) {
				String s = "";
				for (int k = 0; k < j - 1; k++)
					s = 9 + s;
				s = sumOfRaw[i] - (j - 1) * 9 + s;
				raw[i] = new BigInteger(s);
				break;
			} // end if
		} // end for
	}
	
	public int sumOfDigit(BigInteger value){
		int sum = 0;
		BigInteger b = BigInteger.TEN;
		while(!value.equals(BigInteger.ZERO)){
			sum += value.mod(b).intValue();
			value = value.divide(b);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SumOfDigits509C().solve();
	}

}
