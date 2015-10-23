package chapter21;

import java.util.Arrays;
import java.util.concurrent.*;

import chapter15.Generator;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadMethod t = new ThreadMethod("s");
		try {
			System.out.println(t.runTask(4).get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ThreadMethod implements Generator<Integer>{
	private int count = 0;
	private Callable<String> c;
	private String name;
	private ExecutorService exec;
	public ThreadMethod(String name){
		this.name = name;
		exec = Executors.newCachedThreadPool();
	}
	
	public Future<String> runTask(final int n){
		if(c == null){
			c = new Callable<String>(){

				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					Integer[] sequence = new Integer[n];
					for(int i = 0; i < n; i++)
						sequence[i] = next();
					return Arrays.toString(sequence);
				}
				
			};
		}//end if
		Future<String> s =  exec.submit(c);
		exec.shutdown();
		return s;
	}//end runtask

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return fib(count++);
	}
	
	public int fib(int n){
		if(n < 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}