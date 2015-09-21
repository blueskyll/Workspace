package demo.graph;

public class Topological {

	/**
	 * @param args
	 */
	private Iterable<Integer> order;
	
	public Topological(Digraph g){
		DirectedCycle cycle = new DirectedCycle(g);
		if(!cycle.hasCycle()){
			DepthFirstOrder depth = new DepthFirstOrder(g);
			order = depth.reversePost();
		}
	}
	
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean isDAG(){
		return order != null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymbolDigraph sg = new SymbolDigraph(args[0], args[1]);
		Topological t= new Topological(sg.G());
		for(int v : t.order())
			System.out.println(v + "->" + sg.name(v));
	}

}
