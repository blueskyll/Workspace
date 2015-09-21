package demo.graph;

public class Edge implements Comparable<Edge>{
	private int v;
	private int w;
	private float weight;
	
	public Edge(int v, int w, float weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public float weight(){
		return weight;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int v){
		if(v == this.v)
			return w;
		if(v == w)
			return v;
		return -1;
	}

	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		if(weight > that.weight)
			return 1;
		if(weight < that.weight)
			return -1;
		return 0;
	}
	
	public String toString(){
		return String.format("%d-%d %s", v, w, weight);
	}
}
