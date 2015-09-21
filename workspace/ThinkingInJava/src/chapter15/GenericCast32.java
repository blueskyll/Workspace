package chapter15;

class FixedSizeStack<T> {
	private int index = 0;
	private Object[] storage;
	public FixedSizeStack(int size) {
		storage = new Object[size];
	}
	
	public FixedSizeStack(){}
	int getIndex() { return index; } 
	public void push(T item) { storage[index++] = item; }
	@SuppressWarnings("unchecked")
	public T pop() { return (T)storage[--index]; }
}

public class GenericCast32{
	public static final int SIZE = 10;
	public static void main(String[] args) {
		FixedSizeStack<String> strings = 
			new FixedSizeStack<String>(SIZE);
		for(String s : "A B C D E F G H I J".split(" "))
			strings.push(s);
		// Runtime ArrayIndexOutOfBoundsException:
//		 strings.push("oops"); // Bounds-checking required:
		if(strings.getIndex() < SIZE) strings.push("oops");
		for(int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}					
	}		
		
}
