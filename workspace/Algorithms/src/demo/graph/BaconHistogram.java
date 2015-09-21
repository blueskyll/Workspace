package demo.graph;
/**
 * 4.1.22
 * @author Home
 *
 */
public class BaconHistogram {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymbolGraph sg = new SymbolGraph("D:\\Workspaces\\MyEclipse 10\\Algorithms\\src\\demo\\graph\\input.txt", " ");
		Graph g = sg.G();
		String s = "liulan";
		int v = sg.index(s);
		BreadthFirstPaths bfs = new BreadthFirstPaths(g, v);
		int[] count = new int[sg.st.size()];
		int MAX_COUNT = sg.st.size();
		for(int i = 0; i < g.V(); i++){
			int distance = Math.min(MAX_COUNT, bfs.distTo(g, i));
			count[distance]++;
		}
		
		for(int i = 0; i < sg.st.size(); i += 2)
			System.out.println(i/2 + " -> " + count[i]);
	}

}
