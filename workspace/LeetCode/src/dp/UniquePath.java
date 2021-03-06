package dp;

import java.util.Scanner;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.close();
		System.out.println(new UniquePath().uniquePaths(m, n));
	}

	 public int uniquePaths(int m, int n) {
		 int[][] grid = new int[m + 1][n + 1];
		 
		 for(int i = 1; i <= m; i++)
			 grid[i][1] = 1;
		 for(int i = 1; i <= n;i++)
			 grid[1][i] = 1;
		 
		 for(int i = 2; i <= m; i++)
			 for(int j = 2; j <= n; j++)
				 grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
		 return grid[m][n];
	 }
}
