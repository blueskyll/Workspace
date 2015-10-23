package chapter21;

import java.util.*;
import java.util.concurrent.*;

import chapter15.Generator;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 5; i++)
			executor.execute(new Fibonacci(i + 1));
		executor.shutdown();
	}

}

class Fibonacci implements Generator<Integer>, Runnable{

	private int counter = 0;
	private int n;
	
	public Fibonacci(int n){
		this.n = n;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Integer[] sequence = new Integer[n];
		for(int i = 0; i < n; i++)
			sequence[i] = next();
		System.out.println(n + ": " + Arrays.toString(sequence));
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return fib(counter++);
	}
	
	public int fib(int n){
		if(n < 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
	
}
