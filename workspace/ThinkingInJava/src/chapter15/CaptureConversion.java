package chapter15;

public class CaptureConversion {

	static <T> void f1(Holder<T> holder){
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	
	static <T> void f2(Holder<?> holder){
		f1(holder);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder raw = new Holder<Integer>(1);
		f2(raw);
		Holder rawBasic = new Holder();
		rawBasic.set(new Object());
		f2(rawBasic);
		Holder<?> wildcarded = new Holder<Double>(1.0);
		f2(wildcarded);
	}

}

class Holder<T>{
	private T value;
	
	public Holder(){}
	
	public Holder(T val){
		this.value = val;
	}
	
	public void set(T val){
		value = val;
	}
	
	public T get(){
		return value;
	}
	
	public boolean equals(Object obj){
		return value.equals(obj);
	}
}