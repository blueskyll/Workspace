package greedy;

public class Dijkstra {

	/**
	 * @param args
	 */
	public void dijkstra(int v, float[][] a, float[] dist, int[] prev){
		int n = dist.length - 1;
		if(v < 1 || v > n)
			return;
		boolean[] s = new boolean[n + 1];
		
		for(int i = 1; i <= n; i++){
			dist[i] = a[v - 1][i - 1];
			s[i] = false;
			if(dist[i] == Float.MAX_VALUE)
				prev[i] = 0;
			else
				prev[i] = v;
		}
		dist[v] = 0;
		s[v] = true;
		for(int i = 1; i < n; i++)
		{
			float temp = Float.MAX_VALUE;
			int u = v;
			for(int j = 1; j <= n; j++)
			{
				if(!s[j] && dist[j] < temp)
				{
					u = j;
					temp = dist[j];
				}
			}
			s[u] = true;
			for(int j = 1; j <= n; j++){
				if(!s[j] && a[u - 1][j - 1] < Float.MAX_VALUE){
					float newDist = dist[u] + a[u - 1][j - 1];
					if(newDist < dist[j])
					{
						dist[j] = newDist;
						prev[j] = u;
					}
				}
			}// end for 找到最小距离加入S并更新其他距离值
		}//end for
		
	}
	
	public String traceback(int v, int i, int[] prev){
		if(prev[i] == v)
			return ""; 
		String path ="";
		for(int j = i; prev[j] != v; j = prev[j]){
			path = String.format("%s%s", prev[j] + " ", path);
		}
		return path;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 1;
		float[][] a = {{0, 10, Float.MAX_VALUE, 30, 100}, {Float.MAX_VALUE, 0, 50, Float.MAX_VALUE, Float.MAX_VALUE},
				        {Float.MAX_VALUE, Float.MAX_VALUE, 0, Float.MAX_VALUE, 10}, 
				        {Float.MAX_VALUE, Float.MAX_VALUE, 20, 0, 60}, {Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0}};
		float[] dist = new float[6];
		int[] prev = new int[6];
		Dijkstra d = new Dijkstra();
		d.dijkstra(v, a, dist, prev);
		for(int i = 2; i <= 5; i++){
			String path = "";
			path = "The path from 1 to " + i + " is " + v + " " + d.traceback(v, i, prev) + i;
			System.out.println(path);
		}
		
	}

}
