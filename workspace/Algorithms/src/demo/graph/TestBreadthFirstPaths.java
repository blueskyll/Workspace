package demo.graph;

public class TestBreadthFirstPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(0, 6);
		BreadthFirstPaths test = new BreadthFirstPaths(g, 0);

		for(int w = 0; w < g.V(); w++){
			System.out.println(test.distTo(g, w));
		}
	}

}
