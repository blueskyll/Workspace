package chapter21;

import java.util.*;
import java.util.concurrent.*;

import chapter15.Generator;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<String>> result = new ArrayList<Future<String>>();
		for(int i = 0; i < 5; i++)
			result.add(executor.submit(new Fibonacci2(i + 1)));
		for(Future<String> f : result)
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				executor.shutdown();
			}
	}

}

class Fibonacci2 implements Callable<String>, Generator<Integer>{

	int n;
	int count = 0;
	public Fibonacci2(int n){
		this.n = n;
	}
	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return fib(count++);
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Integer[] sequence = new Integer[n];
		
		for(int i = 0; i < n; i++)
			sequence[i] = next();
		return Arrays.toString(sequence);
	}
	
	public int fib(int n){
		if(n < 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}