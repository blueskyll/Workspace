package chapter21;
import java.util.concurrent.*;

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
		for(int i = 0; i < 5; i++)
			exec.execute(new SimplePriority());
		Thread.yield();
		exec.shutdown();
		exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
		exec.execute(new SimplePriority());
		Thread.yield();
		exec.shutdown();
	}

}

class PriorityThreadFactory implements ThreadFactory{
	private int priority;
	
	public PriorityThreadFactory(int p){
		priority = p;
	}
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r);
		t.setPriority(priority);
		return t;
	}
	
}

class SimplePriority implements Runnable{

	private int countDown = 5;
	private volatile double d;
	
	public String toString(){
		return Thread.currentThread() + ": " + countDown;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			for(int i = 1; i < 100000; i++){
				d += (Math.PI + Math.E) / (double) i;
				if( i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if(--countDown == 0)
				return;
		}
	}
	
}