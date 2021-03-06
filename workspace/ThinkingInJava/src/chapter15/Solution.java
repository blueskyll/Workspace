package chapter15;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(numSquares(s.nextInt()));
	}
	
	 public static int numSquares(int n) {
	        if(n == 1)
	        return 1;
	        else{
	        int count = 0;
	        while(Math.pow(Math.floor(Math.sqrt(n)), 2) != n){
	            count++;
	            n = n - (int)Math.pow(Math.floor(Math.sqrt(n)), 2);
	        }
	        if(count == 0)
	        	return 1;
	        if(n == 1)
	        return count + 1;

	        else
	        	return count;
	        }
	    }

}
