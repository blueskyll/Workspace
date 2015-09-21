package demo.sort;

import demo.sort.CubeSum;
import demo.sort.MaxPQ;

public class CubeSum implements Comparable<CubeSum>{

	/**
	 * @param args
	 */
	int i;
	int j;
	int sum;
	public CubeSum(int i, int j){
		sum = i * i * i + j * j * j;
		this.i = i;
		this.j = j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		MaxPQ<CubeSum> pq = new MaxPQ<CubeSum>();
		for(int i = 0; i <= N; i++)
			pq.insert(new CubeSum(i, i));
		while(!pq.isEmpty()){
			CubeSum cs = pq.delMax();
			for(int i = cs.i; i <= N; i++){
				CubeSum cs1 = new CubeSum(cs.i, i);
				show(cs1);
			}
		}
	}
	private static void show(CubeSum cs) {
		// TODO Auto-generated method stub
		System.out.println(cs.sum + "=" + cs.i + "^3" + "+" + cs.j + "^3");
	}
	@Override
	public int compareTo(CubeSum o) {
		// TODO Auto-generated method stub
		if(this.sum < o.sum)
			return -1;
		if(this.sum > o.sum)
			return 1;
		else
			return 0;
	}

}
