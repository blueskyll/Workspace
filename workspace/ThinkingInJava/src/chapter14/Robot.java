package chapter14;
import java.util.*;

public interface Robot {
	String name();
	String model();
	List<Operation> operations();
	
	class Test{
		public static void test(Robot r){
			if(r instanceof Null){
				System.out.println("Null Robot");
			}
			System.out.println("name: " + r.name());
			System.out.println("model: " + r.model());
			
			for(Operation o : r.operations()){
				System.out.println(o.description());
				o.commands();
			}
		}
	}
	
	
}
