
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	
	private Item[] q;
	private int N = 0;
	private int first = 0;
	private int last = 0;
	
	public Queue(){
		q = (Item[]) new Object[2];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int max){
		assert max >= N;
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++){
			temp[i] = q[(first + i) % q.length];
		}
		q = temp;
		first = 0;
		last = N;
	}
	
	public void enqueue(Item item){
		if(N == q.length)
			resize(2 * q.length);
		q[last++] = item;
		if(last == q.length)
			last = 0;
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty())
			System.out.println("empty queue");
		Item item = q[first];
		q[first] = null;
		N--;
		first++;
		if(first == q.length)
			first = 0;
		if(N > 0 && N == q.length / 4)
			resize(q.length / 2);
		return item;
	}
	
	public Item peek(){
		if(isEmpty())
			System.out.println("empty queue");
		return q[first];
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item>{
		private int i = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				System.out.println("empty");
			Item item = q[(i + first) % q.length];
			i++;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			System.out.println("remove");
		}
		
	}

}
