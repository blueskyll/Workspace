package demo.graph;

import demo.In;
import demo.search.ArrayST;

public class SymbolDigraph {

	/**
	 * @param args
	 */
	
	ArrayST<String, Integer> st;
	private String[] keys;
	private Digraph G;
	
	public SymbolDigraph(String stream, String sp){
		st = new ArrayST<String, Integer>(100);
		In in = new In(stream);
		
		while(in.hasNextLine()){
			String[] s = in.readLine().split(sp);
			for(int i = 0; i < s.length; i++){
				if(!st.contains(s[i])){
					st.put(s[i], st.size());
				}
			}//end for i
			
		}//end while
		
		keys = new String[st.size()];
		for(String name : st.keys())
			keys[st.get(name)] = name;
		
		G = new Digraph(st.size());
		in = new In(stream);
		
		while(in.hasNextLine()){
			String[] s = in.readLine().split(sp);
			int v = st.get(s[0]);
			
			for(int i = 1; i < s.length; i++){
				G.addEdge(v, st.get(s[i]));
			}
		}
		
	}
	
	public boolean contains(String s){
		return st.contains(s);
	}
	
	public String name(int key){
		return keys[key];
	}
	
	public int index(String name){
		return st.get(name);
	}
	
	public Digraph G(){
		return G;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
