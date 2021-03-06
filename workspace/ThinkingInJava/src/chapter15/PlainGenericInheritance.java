package chapter15;

public class PlainGenericInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Setter s = new Setter();
		s.set(s);
		GenericSetter<Setter> g = new GenericSetter<Setter>();
//		s.set(g); //override not overloaded
		
		s.get(s);
	}

}

class GenericSetter<T extends GenericSetter<T>>{
	public void set(T arg){
		System.out.println("GenericSetter set");
	}
	
	public T get(T arg){
		System.out.println("Generic Setter get");
		return arg;
	}
}

class Setter extends GenericSetter<Setter>{
	public void set(Setter s){
		System.out.println("Setter set");
	}
	
	public Setter get(Setter s){
		System.out.println("Setter get");
		return s;
	}
}
