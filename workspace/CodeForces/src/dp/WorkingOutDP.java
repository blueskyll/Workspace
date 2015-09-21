package dp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class WorkingOutDP {
	private int rowNum;
	private int colNum;
	private int[][] calories;
	private long[][] sumCalFromForth1;
	private long[][] sumCalToBack1;
	private long[][] sumCalFromForth2;
	private long[][] sumCalToBack2;
	private long[][] maxCal;
	
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		rowNum = scanner.nextInt();
		colNum = scanner.nextInt();
		
		calories = new int[rowNum + 1][colNum + 1];
		sumCalFromForth1 = new long[rowNum + 1][colNum + 1];
		sumCalToBack1 = new long[rowNum + 2][colNum + 2];
		sumCalFromForth2 = new long[rowNum + 2][colNum + 2];
		sumCalToBack2 = new long[rowNum + 2][colNum + 2];
		maxCal = new long[rowNum + 1][colNum + 1];
		
		for(int i = 1; i <= rowNum; i++)
			for(int j = 1; j <= colNum; j++)
				calories[i][j] = scanner.nextInt();
		scanner.close();
		
		getSumCalFromForth1();
		getSumCalToBack1();
		getSumCalFromForth2();
		getSumCalToBack2();
		calMaxPerNode();
	}
	
	public void getSumCalFromForth1(){
		for(int i = 1; i <= rowNum; i++)
			for(int j = 1; j <= colNum; j++)
				sumCalFromForth1[i][j] = calories[i][j] + Math.max(sumCalFromForth1[i - 1][j], sumCalFromForth1[i][j - 1]);
	}
	
	public void getSumCalToBack1(){
		for(int i = rowNum; i >= 1; i--)
			for(int j = colNum; j >= 1; j--)
				sumCalToBack1[i][j] = calories[i][j] + Math.max(sumCalToBack1[i + 1][j], sumCalToBack1[i][j + 1]);
	}
	
	public void getSumCalFromForth2(){
		for(int i = rowNum; i >= 1; i--)
			for(int j = 1; j <= colNum; j++)
				sumCalFromForth2[i][j] = calories[i][j] + Math.max(sumCalFromForth2[i + 1][j], sumCalFromForth2[i][j - 1]);
	}
	
	public void getSumCalToBack2(){
		for(int j = colNum; j >= 1; j--)
			for(int i = 1; i <= rowNum; i++)
				sumCalToBack2[i][j] = calories[i][j] + Math.max(sumCalToBack2[i - 1][j], sumCalToBack2[i][j + 1]);
	}
	
	public void calMaxPerNode(){
		for(int i = 2; i < rowNum; i++)
			for(int j = 2; j < colNum; j++)
				maxCal[i][j] = Math.max(sumCalFromForth1[i][j - 1] + sumCalToBack1[i][j + 1] + 
						sumCalFromForth2[i + 1][j] + sumCalToBack2[i - 1][j], sumCalFromForth1[i - 1][j] + sumCalToBack1[i + 1][j] +
						sumCalFromForth2[i][j - 1] + sumCalToBack2[i][j + 1]);
		
		long maxResult = 0;
		for(int i = 2; i < rowNum; i++)
			for(int j = 2; j < colNum; j++)
				if(maxCal[i][j] > maxResult)
					maxResult = maxCal[i][j];
		
		System.out.println(maxResult);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WorkingOutDP().solve();
		
	}

}
