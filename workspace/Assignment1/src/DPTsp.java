public class DPTsp {

	
	/*
	 * i结点是否包含在V[]数组中
	 */
	public int isIncluded(int i, int[] v, int n){
		int k = 0;
		for(k = 0; k < n; k++)
			if(v[k] == i)
				break;
		if(k == n)
			return 0;
		return 1;
	}
	
	/*
	 * vRow[]数组中去掉node结点后剩下的结点值在V[][]数组中的索引
	 */
	public int left(int node, int[] vRow, int[][] V){
		int i = 0, index = 0, array_0_count = 0, array_1_count = 0,array_2_count = 0,array_3_count = 0, array_4_count = 0,array_5_count = 0; 
	    int V_0_count = 0,V_1_count = 0,V_2_count = 0,V_3_count = 0, V_4_count = 0,V_5_count = 0;
		int[] temp = new int[5];
		for(i = 0; i < 5; i++){
			if(vRow[i] == node)
				temp[i] = 0; //去掉node顶点
			else
				temp[i] = vRow[i];
				
		}
		
		for(i = 0; i < 5; i++) 
	    { 
	        if(temp[i] == 0) 
	            array_0_count++; 
	        else if(temp[i] == 1) 
	            array_1_count++; 
	        else if(temp[i] == 2) 
	            array_2_count++; 
	        else if(temp[i] == 3)
	            array_3_count++; 
	        else if(temp[i] == 4)
	        	array_4_count++;
	        else
	        	array_5_count++;
	    } 
		
		for(index = 0; index < 32; index++) 
	    { 
	        for(i=0; i < 5; i++) 
	        { 
	            if(V[index][i] == 0) 
	                V_0_count++; 
	            else if(V[index][i] == 1) 
	                V_1_count++; 
	            else if(V[index][i] == 2) 
	                V_2_count++; 
	            else if(V[index][i] == 3) 
	                V_3_count++; 
	            else if(V[index][i] == 4)
	            	V_4_count++;
	            else
	            	V_5_count++;
	        } 
	        if((array_0_count == V_0_count) && (array_1_count == V_1_count) 
	            && (array_2_count == V_2_count) && (array_3_count == V_3_count) && (array_4_count == V_4_count) && (array_5_count == V_5_count)) 
	            return index; 
	        V_0_count = 0; 
	        V_1_count = 0; 
	        V_2_count = 0; 
	        V_3_count = 0; 
	        V_4_count = 0;
	        V_5_count = 0;
	    } 
		return 0;
	}
	
	public DPTsp(){}
	
	public void DPtsp(int[][] shortestP, int[][] distance, int[][] V, int[][] flag, int n){
		int i = 0, j = 0, k = 0;
		for(i = 1; i < n; i++)
			shortestP[i][0] = distance[i][0];
		for(j = 1; j < 31; j++)
		{
			for(i = 1; i < n; i++)
			{
				if(isIncluded(i, V[j], 5) == 0)
				{
					for(k = 0; k < 5;k++)
					{
						if((V[j][k] != 0) && 
								((distance[i][V[j][k]] + shortestP[V[j][k]][left(V[j][k], V[j], V)] < shortestP[i][j])))
						{
							
							shortestP[i][j] = distance[i][V[j][k]] + shortestP[V[j][k]][left(V[j][k], V[j], V)];//求出从i结点经过V[j][k]到j结点的最小距离并记录结点值
							flag[i][j] = V[j][k];
						}
					}
				}
			} //end of for(i = 1; i < n; i++)
		}//end of for(j = 1; j < 31; j++)
		
		for(k = 0; k < 5; k++) //求出从0结点遍历所有结点并回到0结点的最小距离
		{
			if((V[31][k] != 0) && (distance[0][V[31][k]] + shortestP[V[31][k]][left(V[31][k], V[31], V)] < shortestP[0][31]))
			{
				shortestP[0][31] = distance[0][V[31][k]] + shortestP[V[31][k]][left(V[31][k], V[31], V)];
				flag[0][31] = V[31][k];
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPTsp tsp = new DPTsp();
		int [][]flag = new int[6][32];
		int shortestP[][] = new int[6][32];
		
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 32; j++)
				shortestP[i][j] = 1000; //假设1000为无穷大
		
		int V[][] = {{0,0,0,0,0},{0,0,0,0,1},{0,0,0,0,2}, {0,0,0,0,3},
				     {0,0,0,0,4},{0,0,0,0,5},{0,0,0,1,2},{0,0,0,1,3},
				     {0,0,0,1,4},{0,0,0,1,5},{0,0,0,2,3},{0,0,0,2,4},
				     {0,0,0,2,5},{0,0,0,3,4},{0,0,0,3,5},{0,0,0,4,5},
				     {0,0,1,2,3},{0,0,1,2,4},{0,0,1,2,5},{0,0,1,3,4},
				     {0,0,1,3,5},{0,0,1,4,5},{0,0,2,3,4},{0,0,2,3,5},
				     {0,0,2,4,5},{0,0,3,4,5},{0,1,2,3,4},{0,1,2,3,5},
				     {0,1,2,4,5},{0,1,3,4,5},{0,2,3,4,5},{1,2,3,4,5}
				    };
		int distance[][] = {{0,10,20,30,40,50},{12,0,18,30,25,21},{23,19,0,5,10,15},
				            {34,32,4,0,8,16},{45,27,11,10,0,18},{56,22,16,20,12,0}};
		tsp.DPtsp(shortestP, distance, V, flag, 6);
		System.out.println("the minimal value is " + shortestP[0][31]);
		
		int row = 0;
		int col = 31;
		System.out.print("the shortest path is " + "0->");
		for(int i = 0; i < 6; i++)
		{
			int m = flag[row][col];
			if(i != 5)
				System.out.print(m + "->");
			else
				System.out.print(m);
			row = m;
			col = tsp.left(m, V[col], V);
		}
	}

}








		

