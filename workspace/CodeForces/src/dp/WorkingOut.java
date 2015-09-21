package dp;

import java.util.Scanner;

public class WorkingOut {

	private int rowNum;
	private int colNum;
	private int[][] calories;
	private long[][] sumCalFromForth1;
	private long[][] sumCalFromBack1;
	private long[][] sumCalFromForth2;
	private long[][] sumCalFromBack2;
	private long[][] maxCal;
	
	public void solve(){
		Scanner scanner = new Scanner(System.in);
		rowNum = scanner.nextInt();
		colNum = scanner.nextInt();
		
		calories = new int[rowNum][colNum];
		sumCalFromForth1 = new long[rowNum][colNum];
		sumCalFromBack1 = new long[rowNum][colNum];
		sumCalFromForth2 = new long[rowNum][colNum];
		sumCalFromBack2 = new long[rowNum][colNum];
		maxCal = new long[rowNum][colNum];
		
		for(int i = 0; i < rowNum; i++)
			for(int j = 0; j < colNum; j++)
				calories[i][j] = scanner.nextInt();
		scanner.close();
		
		getSumCalFromForth1();
		getSumCalFromBack1();
		getSumCalFromForth2();
		getSumCalFromBack2();
		calMaxPerNode();
	}
	
	public void calMaxPerNode(){
		maxCal[0][0] = Math.max(sumCalFromBack1[1][0], sumCalFromBack1[0][1]) + sumCalFromForth2[1][0] + sumCalFromBack2[0][1];
		
		maxCal[rowNum - 1][0] = sumCalFromForth1[rowNum - 2][0] + sumCalFromBack1[rowNum - 1][1] + 
				Math.max(sumCalFromBack2[rowNum - 1][1], sumCalFromBack2[rowNum - 2][0]);
		
		maxCal[0][colNum - 1] = sumCalFromForth1[0][colNum - 2] + sumCalFromBack1[1][colNum - 1] + 
				Math.max(sumCalFromForth2[0][colNum - 2], sumCalFromForth2[1][colNum - 1]);
		
		maxCal[rowNum - 1][colNum - 1] = Math.max(sumCalFromForth1[rowNum - 2][colNum - 1], sumCalFromForth1[rowNum - 1][colNum - 2]) +
				sumCalFromForth2[rowNum - 1][colNum - 2] + sumCalFromBack2[rowNum - 2][colNum - 1];
		
		for(int i = 1; i < colNum - 1; i++)
		{
			maxCal[0][i] = sumCalFromForth1[0][i - 1] + Math.max(sumCalFromBack1[1][i], sumCalFromBack1[0][i + 1]) +
			    Math.max(sumCalFromForth2[0][i - 1], sumCalFromForth2[1][i]) + sumCalFromBack2[0][i + 1];
			maxCal[rowNum - 1][i] = Math.max(sumCalFromForth1[rowNum - 2][i], sumCalFromForth1[rowNum - 1][i - 1]) + 
					sumCalFromBack1[rowNum - 1][i + 1] + sumCalFromForth2[rowNum - 1][i - 1] + 
					Math.max(sumCalFromBack2[rowNum - 1][i + 1], sumCalFromBack2[rowNum - 2][i]);
		}
		
		for(int i = 1; i < rowNum - 1; i++)
		{
			maxCal[i][0] = sumCalFromForth1[i - 1][0] + Math.max(sumCalFromBack1[i + 1][0], sumCalFromBack1[i][1]) + 
			    Math.max(sumCalFromBack2[i][1], sumCalFromBack2[i - 1][0]);
			maxCal[i][colNum - 1] = Math.max(sumCalFromForth1[i - 1][colNum - 1], sumCalFromForth1[i][colNum - 2]) +
					sumCalFromBack1[i + 1][colNum - 1] + Math.max(sumCalFromForth2[i][colNum - 2], sumCalFromForth2[i + 1][colNum - 1]) +
					sumCalFromBack2[i - 1][colNum - 1];
		}
		
		for(int i = 1; i < rowNum - 1; i++)
			for(int j = 1; j < colNum - 1; j++)
				maxCal[i][j] = Math.max(sumCalFromForth1[i - 1][j], sumCalFromForth1[i][j - 1]) +
				               Math.max(sumCalFromBack1[i + 1][j], sumCalFromBack1[i][j + 1]) +
				               Math.max(sumCalFromForth2[i][j - 1], sumCalFromForth2[i + 1][j]) +
				               Math.max(sumCalFromBack2[i][j + 1], sumCalFromBack2[i - 1][j]);
		
		long maxResult = 0;
		for(int i = 0; i < rowNum; i++)
			for(int j = 0; j < colNum; j++)
				if(maxCal[i][j] > maxResult)
					maxResult = maxCal[i][j];
		
		System.out.println(maxResult);
	}
	
	public void getSumCalFromForth1(){
		sumCalFromForth1[0][0] = calories[0][0];
		
		for(int i = 1; i < colNum; i++)
			sumCalFromForth1[0][i] = sumCalFromForth1[0][i - 1] + calories[0][i];
		
		for(int i = 1; i < rowNum; i++)
			sumCalFromForth1[i][0] = sumCalFromForth1[i - 1][0] + calories[i][0];
		
		for(int i = 1; i < rowNum; i++)
			for(int j = 1; j < colNum; j++)
				sumCalFromForth1[i][j] = Math.max(sumCalFromForth1[i - 1][j], sumCalFromForth1[i][j - 1]);
	}
	
	public void getSumCalFromBack1(){
		sumCalFromBack1[rowNum - 1][colNum - 1] = calories[rowNum - 1][colNum - 1];
		
		for(int i = colNum - 2; i >= 0; i--)
			sumCalFromBack1[rowNum - 1][i] = sumCalFromBack1[rowNum - 1][i + 1] + calories[rowNum - 1][i];
		
		for(int i = rowNum - 2; i >= 0; i--)
			sumCalFromBack1[i][colNum - 1] = sumCalFromBack1[i + 1][colNum - 1] + calories[i][colNum - 1];
		
		for(int i = rowNum - 2; i >= 0; i--)
			for(int j = colNum - 2; j >= 0; j--)
				sumCalFromBack1[i][j] = Math.max(sumCalFromBack1[i][j + 1], sumCalFromBack1[i + 1][j]);
	}
	
	public void getSumCalFromForth2(){
		sumCalFromForth2[rowNum - 1][0] = calories[rowNum - 1][0];
		
		for(int i = 1; i < colNum; i++)
			sumCalFromForth2[rowNum - 1][i] = sumCalFromForth2[rowNum - 1][i - 1] + calories[rowNum - 1][i];
		
		for(int i = rowNum - 2; i >= 0; i--)
			sumCalFromForth2[i][0] = sumCalFromForth2[i + 1][0] + calories[i][0];
		
		for(int i = rowNum - 2; i >= 0; i--)
			for(int j = 1; j < colNum; j++)
				sumCalFromForth2[i][j] = Math.max(sumCalFromForth2[i][j - 1], sumCalFromForth2[i + 1][j]);
	}
	
	public void getSumCalFromBack2(){
		sumCalFromBack2[0][colNum - 1] = calories[0][colNum - 1];
		
		for(int i = colNum - 2; i >= 0; i--)
			sumCalFromBack2[0][i] = sumCalFromBack2[0][i + 1] + calories[0][i];
		
		for(int i = 1; i < rowNum; i++)
			sumCalFromBack2[i][colNum - 1] = sumCalFromBack2[i - 1][colNum - 1] + calories[i][colNum - 1];
		
		for(int i = 1; i < rowNum - 1; i++)
			for(int j = colNum - 2; j >= 0; j--)
				sumCalFromBack2[i][j] = Math.max(sumCalFromBack2[i][j + 1], sumCalFromBack2[i - 1][j]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WorkingOut().solve();
	}

}
