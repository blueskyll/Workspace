package greedy;

import demo.sort.MinPQ;


public class HuffmanCoding {

	/**
	 * @param args
	 */
	static class HuffmanTreeNode implements Comparable{
		HuffmanTreeNode left,right;
		float weight;
		//一个树是由树结点构成的，树结点记录3个信息，该点跟信息，此处用一个float值足够，还有左右子树
		//同时为了知道输出的编码是为谁输出的，我们记录该顶点的索引
		int index;
		
		HuffmanTreeNode(float w,int i)
		{
			weight=w;
			right = null;
			left = null;
			index=i;
		}
		HuffmanTreeNode(HuffmanTreeNode l,HuffmanTreeNode r,float w,int i){
			weight=w;
			left=l;
			right=r;
			index=i;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			float xw = ((HuffmanTreeNode)o).weight;
			if(weight < xw) return -1;
			else if(weight > xw) return 1;
			return 0;
		}
		
	}
	
	public static HuffmanTreeNode makeHuffmanTree(float[] f){
		int n = f.length;
		HuffmanTreeNode w;//不需要n+1的数组存储，必要存储可使用n个，此处只是临时求一下，可以只用一个w
		MinPQ pq = new MinPQ<HuffmanTreeNode>();
		for(int i = 0; i < n; i++){
			w = new HuffmanTreeNode(f[i],i+1);
			pq.insert(w);
		}
		for(int i = 1; i < n; i++){
			HuffmanTreeNode x = (HuffmanTreeNode) pq.delMin();
			HuffmanTreeNode y = (HuffmanTreeNode) pq.delMin();
			HuffmanTreeNode z=new HuffmanTreeNode(x,y,x.weight+y.weight,x.index+y.index);
			pq.insert(z);
		}
		return (HuffmanTreeNode)pq.delMin();
	}
	public static void traverse(HuffmanTreeNode t,String code){
		if(t == null)
			return;
		if(t.left==null&&t.right==null)//是叶子结点
		{
			System.out.println("第"+t.index+"个数据\t"+t.weight+"\t编码为\t"+code);
		}
		else {
			//haffman树中只存在0结点和2结点，所以一个顶点不是叶子结点，必然有左右孩子
			//每左走一次，加一个0，右走一次加个1.
			traverse(t.left,code+'0');
			traverse(t.right,code+'1');
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f[] = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f,0.5f};
		HuffmanTreeNode root=makeHuffmanTree(f);
		traverse(root,"");
	}

}
