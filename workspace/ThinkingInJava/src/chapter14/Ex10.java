package chapter14;

public class Ex10 {	
	public static void main(String[] args) {
		char[] c = new char[10];
		// c is an Object:		
		System.out.println("Superclass of char[] c: " + 
			c.getClass().getSuperclass());
		System.out.println("char[] c instanceof Object: " + 
			(c instanceof Object));
	}
}