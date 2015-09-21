package traceback;

public class TravelSalesman {

	/**
	 * @param args
	 */
	private static int n;//顶点数
	private static int[] x;//current solution
	private static int[] bestx; //the best solution currently
	private static float bestc; // best value currently
	private static float cc;//current fee
	private static float [][]a; //adjacent matrix
	
	public TravelSalesman(int nn, float[][] aa){
		n = nn;
		a = aa;
	}
	
	public float tsp(int []v){
		x = new int[n+1];
		for(int i = 1; i <= n; i++)
			x[i] = i;
		bestc = Float.MAX_VALUE;
		cc = 0;
		bestx = v;
		traceback(2);
		return bestc;
	}
	
	public void traceback(int i){
		if(i == n)
		{
			if(a[x[i - 1] - 1][i - 1] < Float.MAX_VALUE && a[x[i] - 1][1 - 1] < Float.MAX_VALUE && 
			   (bestc == Float.MAX_VALUE || cc + a[x[i - 1] - 1][i - 1] + a[x[n] - 1][1 - 1] < bestc)){
				bestc = cc + a[x[i - 1] - 1][i - 1] + a[x[n] - 1][1 - 1];
				for(int j = 1; j <= n; j++)
					bestx[j] = x[j];
			}
		}
		else
		{
			for(int j = i; j <= n; j++)
			{
				System.out.println(i + " " + j);
				if(a[x[i - 1] - 1][x[j] - 1] < Float.MAX_VALUE &&
						(bestc < Float.MAX_VALUE || cc + a[x[i - 1] - 1][x[j] - 1] < bestc)){
					swap(x, i, j);//after swap, x[i] store the last selected node. x数组依顺序存储选中的值，所以需要交换 排序的思想
					cc += a[x[i - 1] - 1][x[i] - 1];
					traceback(i + 1);
					cc -= a[x[i - 1] - 1][x[i] - 1];
					swap(x, i, j);
				}
//				System.out.println(1 + "->" + (i - 1) + " " + j + " end");
			}
		}
	}
	
	public void swap(int[] a, int i, int j){
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		float[][] a = {{0, 30, 6, 4}, {30, 0, 5, 10}, {6, 5, 0, 20}, {4, 10, 20, 0}};
		TravelSalesman t = new TravelSalesman(n, a);
		int[] v = {0, 1, 2, 3, 4};
		float value = t.tsp(v);
		System.out.println(value);
	}

}
