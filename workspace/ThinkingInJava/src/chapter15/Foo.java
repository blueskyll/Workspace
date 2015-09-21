package chapter15;

public class Foo <T>{

	T var;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo<Integer> f = new Foo<Integer>();
		System.out.println(f.getClass());
	}

}
