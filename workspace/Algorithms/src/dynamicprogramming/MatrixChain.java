package dynamicprogramming;

public class MatrixChain {

	/**
	 * @param args
	 * ��̬�滮�㷨����׶ξ������Ż�
	 * ��̬�滮�ʺ��ڽ�����ֽ�õ������������������໥�����ģ��Ե�����
	 * �����������ӽṹ���������ص�����
	 */
	private int p[];
	private int s[][];
	private int m[][];
	private int length;

	public void calMatrixChain() {
		int n = this.length - 1;

		for (int i = 0; i <= n; i++) {
			this.m[i][i] = 0;
		}

		//�����Ϊ1�����Ϊn-1������m[i][i+1]ֱ��m[0][n-1]����Сֵ
		for (int r = 1; r <= n; r++) {
			for (int i = 0; i < n - r + 1; i++) {
				int j = i + r;
				this.m[i][j] = this.m[i + 1][j] + this.p[i] * this.p[i + 1]
						* this.p[j + 1];//�ֽ�Ϊm[i][i] + m[i+1][j] + p......
				this.s[i][j] = i;
				for (int k = i + 1; k < j; k++) {
					int t = this.m[i][k] + this.m[k + 1][j] + this.p[i]//�����ֽ�����ĵڶ���mֵ����һ��mֵ�������Сֵ
							* this.p[k + 1] * this.p[j + 1];
					if (t < this.m[i][j]) {
						this.m[i][j] = t;
						this.s[i][j] = k;
					}
				}
			}
		}
	}
	
	
	/*��������ż������
	 * 
	 */
	public void traceback(int[][] s, int i, int j) {
		if (i == j)
			return;
		traceback(s, i, s[i][j]);
		traceback(s, s[i][j] + 1, j);
		System.out.println("Multiply A" + i + "," + s[i][j] + "and A"
				+ (s[i][j] + 1) + "," + j);
	}

	public MatrixChain() {
		p = null;
		s = null;
		m = null;
		length = 0;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public int[][] getS() {
		return s;
	}

	public void setS(int[][] s) {
		this.s = s;
	}

	public int[][] getM() {
		return m;
	}

	public void setM(int[][] m) {
		this.m = m;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixChain mc = new MatrixChain();
		int p[] = { 30, 35, 15, 5, 10, 20, 25 };  //��������ֵ
		int[][] m = new int[6][6];//�洢������Сֵ
		int[][] s = new int[6][6];//�����Сֵλ��
		mc.setP(p);
		mc.setLength(6);
		mc.setM(m);
		mc.setS(s);
		mc.calMatrixChain();
		for (int i = 0; i < mc.length; i++) {
			for (int j = 0; j < mc.length; j++)
				System.out.print(m[i][j] + "     ");
			System.out.println();
		}
		mc.traceback(mc.s, 0, mc.length - 1);
	}

}
