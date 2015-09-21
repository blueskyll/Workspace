package demo.sort;

/*
 * 2.4.3
 */
public class OrderedLinkedQueue<Key extends Comparable<Key>> {

	/**
	 * @param args
	 */
	
	QueueNode rear;//队尾指针
	QueueNode front;//队首指针
	int N;
	public OrderedLinkedQueue(){
		rear = null;
		front = null;
		N = 0;;
	}
	
	public void enqueue(Key data){
		if(rear == null && front == null){
			rear = new QueueNode(data);
			front = rear;
		}else{
			QueueNode node = new QueueNode(data);
			QueueNode tempRear = rear;
			while(tempRear != null && tempRear.front != null && (tempRear.data).compareTo(node.data) < 0){
				tempRear = tempRear.front;
			}
			if(tempRear.front != null ||(tempRear.front == null && (tempRear.data).compareTo(node.data) >= 0))
			{
				node.next = tempRear.next;
			    node.front = tempRear;
		    	tempRear.next = node;
		    	if(rear == tempRear){
		    		rear = node;
		    	}
			}
			else{
				tempRear.front = node;
				node.next = tempRear;
				node.front = null;
				front = node;
				
				
			}
		}
		N++;
	}
	
	public Object dequeue(){
		if(rear == null)
			return null;
		if(front == rear && rear != null){
			QueueNode node = front;
			front = rear = null;
			return node.data;
		}
		QueueNode obj = front;
		front.next.front = null;
		front = front.next;
		N--;
		return obj.data;
	}
	private class QueueNode <Key extends Comparable<Key>>{
		Key data;
		QueueNode next;
		QueueNode front;
		
		public QueueNode(){
			this(null, null, null);
		}
		public QueueNode(Key data){
			this(data, null, null);
		}
		public QueueNode(Key data, QueueNode next, QueueNode front){
			this.data = data;
			this.next = next;
			this.front = front;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedLinkedQueue q = new OrderedLinkedQueue();
		q.enqueue("dd");
		q.enqueue("ddd");
		q.enqueue("dddd");
		q.enqueue("c");
		q.enqueue("d");
		int length = q.N;
		for(int k = 0; k < length; k++){
			System.out.println(q.dequeue());
		}
	}

}
