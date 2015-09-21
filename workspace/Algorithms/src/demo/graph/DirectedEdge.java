package demo.graph;

public class DirectedEdge {
	private int v;
	private int w;
	private float weight;
	
	public DirectedEdge(int v, int w, float weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int to(){
		return w;
	}
	
	public int from(){
		return v;
	}
	
	public float weight(){
		return weight;
	}
	
	public String toString(){
		return String.format("%d -> %d : %s", v, w, weight);
	}
}
