package chapter15;

interface FactoryI<T>{
	T create();
}

class Foo2<T>{
	private T x;
	public <F extends FactoryI<T>> Foo2(F factory){
		x = factory.create();
	}
}

class IntegerFactory implements FactoryI<Integer>{
	public Integer create(){
		return new Integer(0);
	}
}

public class FactoryConstraint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Foo2<Integer>(new IntegerFactory());
	}

}
