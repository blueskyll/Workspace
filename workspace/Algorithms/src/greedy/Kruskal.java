package greedy;

import demo.QuickUnion;
import demo.sort.MinPQ;

public class Kruskal {

	private EdgeNode e;
	/**
	 * @param args
	 */
	private class EdgeNode implements Comparable{
		float weight;
		int u;
		int v;
		
		private EdgeNode(float w, int uu, int vv){
			weight = w;
			u = uu;
			v = vv;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			float w = ((EdgeNode) o).weight;
			if(weight < w)
				return -1;
			if(weight > w)
				return 1;
			return 0;
		}
	}
	
	public boolean kruskal(int n, EdgeNode[] e, EdgeNode[] t){
		MinPQ<EdgeNode> pq = new MinPQ<EdgeNode>();
		for(int i = 0; i < e.length; i++){
			pq.insert(e[i]);
		}
		int k = 0;
		int eNum = e.length;
		QuickUnion qu = new QuickUnion(n);
		while(eNum > 0 && k < n - 1){
			EdgeNode min = pq.delMin();
			eNum--;
			int a = qu.find(min.u - 1);
			int b = qu.find(min.v - 1);
			if(a != b){
				t[k++] = min;
				qu.union(a, b);
				System.out.println("the path selected is " + min.u  + " " + min.v + " and distance is " + (int)min.weight);
			}
		}// end while
		
		return (k == n - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kruskal k = new Kruskal();
		int n = 6;
		EdgeNode[] e = new EdgeNode[10];
		String[] s = {"6,1,2", "1,1,3", "5,1,4", "5,2,3", "3,2,5", "5,3,4", "6,3,5", "4,3,6", "2,4,6", "6,5,6"};
//		e[0] = new EdgeNode(6, 1, 2);
		for(int i = 0; i < 10; i++)
		{
			String[] temp = s[i].split(",");
			e[i] = k.new EdgeNode(Float.parseFloat(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		}
		EdgeNode[] t= new EdgeNode[10];
		k.kruskal(n, e, t);
	}

}
