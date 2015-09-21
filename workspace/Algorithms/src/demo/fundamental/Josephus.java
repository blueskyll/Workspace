package demo.fundamental;

public class Josephus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 2;
		int N = 7;
		Queue<Integer> q = new Queue<Integer>();
		for(int i = 0; i < N; i++)
			q.enqueue(i);
		while(!q.isEmpty()){
			for(int i = 0; i < M - 1; i++){
				q.enqueue(q.dequeue());
			}
			System.out.print(q.dequeue() + " ");
		}
		System.out.println();
	}

}
