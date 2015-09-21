package greedy;

import demo.sort.MinPQ;

public class HuffmanCode {

	/**
	 * @param args
	 */
	private static class Huffman implements Comparable{
		Bintree tree;
		float weight;
		
		private Huffman(Bintree bt, float w){
			tree = bt;
			weight = w;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			float xw = ((Huffman)o).weight;
			if(weight < xw) return -1;
			else if(weight > xw) return 1;
			return 0;
		}
		
	}
	
	private static class Bintree{
		Object root;
		Bintree right;
		Bintree left;

		private Bintree(){
			root = null;
			right = null;
			left = null;
		}
		private void makeTree(Object r, Bintree left, Bintree right){
			root = r;
			this.right = right;
			this.left = left;
		}
	}
	
	public static Huffman huffmanTree(float[] f){
		int n = f.length;
		Huffman[] w = new Huffman[n+1];
		Bintree zero = null;
		for(int i = 0; i < n; i++){
			Bintree x= new Bintree();
			x.makeTree(i, zero, zero);
			w[i + 1] = new Huffman(x, f[i]);
		}
		
		MinPQ pq = new MinPQ<Huffman>();
		int length = w.length - 1;
		for(int i = 1; i <= length; i++){
			pq.insert(w[i]);
		}
		for(int i = 1; i < length; i++){
			Huffman x = (Huffman) pq.delMin();
			Huffman y = (Huffman) pq.delMin();
			Bintree z = new Bintree();
			z.makeTree(null, x.tree, y.tree);
			Huffman t = new Huffman(z, x.weight + y.weight);
			pq.insert(t);
		}
		return (Huffman)pq.delMin();
	}
//	public static void traverse(Bintree t){
////		if(t.left != null){
////			System.out.print(1);
////			traverse(t.left);
////		}
////		System.out.println();
////		System.out.print(t.root);
//		
//		if(t.left != null){
//			System.out.print(1);
//		}
//	}
	
	public static void traverse(Bintree t,String code){		
		if(t.left==null)
		{
			System.out.println(code + ":" + t.root);
			return;
		}
		if(t.right == null){
			System.out.println(code + ":" + t.root);
			return;
		}
		else {
			if(t.left!=null)
				traverse(t.left,code+'0');
			if(t.right!=null)
				traverse(t.right,code+'1');
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f[] = {0.1f, 0.2f, 0.5f};
		HuffmanCode hc = new HuffmanCode();
		Huffman h = hc.huffmanTree(f);
		Bintree b = h.tree;
		String s ="";
		traverse(b, s);
	}

}
