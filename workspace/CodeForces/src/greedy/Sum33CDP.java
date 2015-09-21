package greedy;

import java.util.Scanner;

public class Sum33CDP {
	private int num;
	private int[] seq;
	
	public void solve(){
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		seq = new int[num + 1];
		int temp = 0;
		int s = 0;
		for(int i = 1; i <= num; i++){
			seq[i] = scanner.nextInt();
			sum += seq[i];
			if(sum < 0)
				sum = 0;
			temp = Math.max(temp, sum);
			s += seq[i];
		}
		scanner.close();
		System.out.println(2 * temp - s);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sum33CDP().solve();
	}

}
