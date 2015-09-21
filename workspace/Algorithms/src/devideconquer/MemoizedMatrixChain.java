package devideconquer;

import dynamicprogramming.MatrixChain;

public class MemoizedMatrixChain {

	/**
	 * 备忘录方法和递归一样使用自顶向上的方法，但是用备忘录的方法记录子问题的答案，在下次需要解决该子问题时，只需查看而无需计算
	 * 是相对递归的优点
	 * 减少了动态规划算法的计算时间和空间需求
	 * @param args
	 */
	int p[];
	int m[][];
	int s[][];
	int length;
	
	public MemoizedMatrixChain(){
		this.p = null;
		this.m = null;
		this.s = null;
		this.length = 0;
	}
	
	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public int[][] getM() {
		return m;
	}

	public void setM(int[][] m) {
		this.m = m;
	}

	public int[][] getS() {
		return s;
	}

	public void setS(int[][] s) {
		this.s = s;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int memoizedMatrixChain(){
		int n = this.length;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
				m[i][j] = 0;
		}
		return lookupChain(0,n - 1);
	}
	
	public int lookupChain(int i, int j){
		if(m[i][j] > 0) return m[i][j];
		if(i == j) return 0;
		int u = lookupChain(i + 1, j) + p[i]*p[i+1]*p[j + 1];
		s[i][j] = i;
		for(int k = i + 1;k < j; k++){
			int t = lookupChain(i, k) + lookupChain(k + 1, j) + p[i]*p[k + 1]*p[j + 1];
			if(t < u){
				u = t;
				s[i][j] = k;
			}
		}
		m[i][j] = u;
		return u;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemoizedMatrixChain mc = new MemoizedMatrixChain();
		int p[] = { 30, 35, 15, 5, 10, 20, 25 };
		int[][] m = new int[6][6];
		int[][] s = new int[6][6];
		mc.setP(p);
		mc.setLength(6);
		mc.setM(m);
		mc.setS(s);
		mc.memoizedMatrixChain();
		for (int i = 0; i < mc.length; i++) {
			for (int j = 0; j < mc.length; j++)
				System.out.print(m[i][j] + "     ");
			System.out.println();
		}
	}

}
