package chapter15;

public class SelfBounded34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildSelfBounded csb = new ChildSelfBounded();
		csb.method1(csb).method2(csb);
	}

}

abstract class SelfBounded<T extends SelfBounded<T>>{
	abstract T method1(T arg);
	public T method2(T arg){
		System.out.println("method2");
		return method1(arg);
	}
}

class ChildSelfBounded extends SelfBounded<ChildSelfBounded>{
 
	@Override
	ChildSelfBounded method1(ChildSelfBounded arg) {
		// TODO Auto-generated method stub
		System.out.println("child method1");
		return new ChildSelfBounded();
	}
	
}