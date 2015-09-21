package greedy;

import demo.sort.MinPQ;


public class HuffmanCoding {

	/**
	 * @param args
	 */
	static class HuffmanTreeNode implements Comparable{
		HuffmanTreeNode left,right;
		float weight;
		//һ������������㹹�ɵģ�������¼3����Ϣ���õ����Ϣ���˴���һ��floatֵ�㹻��������������
		//ͬʱΪ��֪������ı�����Ϊ˭����ģ����Ǽ�¼�ö��������
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
		HuffmanTreeNode w;//����Ҫn+1������洢����Ҫ�洢��ʹ��n�����˴�ֻ����ʱ��һ�£�����ֻ��һ��w
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
		if(t.left==null&&t.right==null)//��Ҷ�ӽ��
		{
			System.out.println("��"+t.index+"������\t"+t.weight+"\t����Ϊ\t"+code);
		}
		else {
			//haffman����ֻ����0����2��㣬����һ�����㲻��Ҷ�ӽ�㣬��Ȼ�����Һ���
			//ÿ����һ�Σ���һ��0������һ�μӸ�1.
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
