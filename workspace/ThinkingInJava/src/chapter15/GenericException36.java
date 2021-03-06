package chapter15;

import java.util.*;

interface Processor<T, E extends Exception, F extends Exception>{
	void process(List<T> resultCollection) throws E, F;
}

class ProcessorRunner<T, E extends Exception, F extends Exception> extends ArrayList<Processor<T, E, F>>{
	List<T> processAll() throws E, F{
		List<T> resultCollection = new ArrayList<T>();
		for(Processor<T, E, F> processor : this){
			processor.process(resultCollection);
		}
		return resultCollection;
	}
}

class Failure1 extends Exception {}
class Failure2 extends Exception {}

class Processor1 implements Processor<String, Failure1, Failure2>{
	static int count = 3;
	@Override
	public void process(List<String> resultCollection) throws Failure1, Failure2 {
		// TODO Auto-generated method stub
		if(count-- == 0)
			resultCollection.add("ByeBye");
		else
			resultCollection.add("Hello");
		if(count < 0)
			throw new Failure1();
		if(count < -1)
			throw new Failure2();
		}
	
}

public class GenericException36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessorRunner<String, Failure1, Failure2> runner = new ProcessorRunner<String, Failure1, Failure2>();
		for(int i = 0 ; i< 4; i++) {
			runner.add(new Processor1());
		}
		try {
			System.out.println(runner.processAll());
		} catch (Failure1 e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (Failure2 e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
