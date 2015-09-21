package devideconquer;

import dynamicprogramming.MatrixChain;

public class MemoizedMatrixChain {

	/**
	 * ����¼�����͵ݹ�һ��ʹ���Զ����ϵķ����������ñ���¼�ķ�����¼������Ĵ𰸣����´���Ҫ�����������ʱ��ֻ��鿴���������
	 * ����Եݹ���ŵ�
	 * �����˶�̬�滮�㷨�ļ���ʱ��Ϳռ�����
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
