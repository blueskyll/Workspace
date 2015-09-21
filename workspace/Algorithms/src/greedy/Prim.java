package greedy;

public class Prim {

	/**
	 * @param args
	 */
	public void prim(int n, float[][] a){
		int[] closet = new int[n + 1];
		float[] lowcost = new float[n + 1];
		boolean[] s = new boolean[n + 1];
		s[1] = true;
		for(int i = 2; i <= n; i++){
			lowcost[i] = a[0][i - 1];
			closet[i] = 1;
			s[i] = false;
		}// end for i
		
		for(int i = 1; i < n; i++)
		{
			float min = Float.MAX_VALUE;
			int k = 1;
			for(int j = 2; j <= n; j++){
				if(j == 7)
				{
					int h = 1;
				}
				if(!s[j] && lowcost[j] < min){
					min = lowcost[j];
					k = j;
				}
			}// end for j
			System.out.println(k + "," + closet[k]);
			s[k] = true;
			for(int j = 2; j <= n; j++){
				if(!s[j] && a[k - 1][j - 1] < lowcost[j]){
					lowcost[j] = a[k - 1][j - 1];
					closet[j] = k;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		float[][] a= {{0, 6, 1, 5, Float.MAX_VALUE, Float.MAX_VALUE},
				     {6, 0, 5, Float.MAX_VALUE, 3, Float.MAX_VALUE},
				     {1, 5, 0, 5, 6, 4},
				     {5, Float.MAX_VALUE, 5, 0, Float.MAX_VALUE, 2},
				     {Float.MAX_VALUE, 3, 6, Float.MAX_VALUE, 0, 6},
				     {Float.MAX_VALUE, Float.MAX_VALUE, 4, 2, 6, 0}};
		new Prim().prim(n, a);
	}

}
