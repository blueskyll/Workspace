package chapter14;
import java.util.*;

class Part{
	public String toString(){
		return getClass().getSimpleName();
	}
	
	static List<Factory<? extends Part>> partFactories = 
			new ArrayList<Factory<? extends Part>>();
	
	static{
//		Collections.addAll(partFactories, new FuelFilter.Factory(), new AirFilter.Factory());
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new FanBelt.Factory());
	}
	
	private static Random rand = new Random(47);
	public static Part createRandom(){
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}

}

class Filter extends Part{}

class AirFilter extends Filter{
	public static class Factory implements chapter14.Factory<AirFilter>{
		@Override
		public AirFilter create(){
			return new AirFilter();
		}
	}
}

class FuelFilter extends Filter{
	public static class Factory implements chapter14.Factory<FuelFilter>{

		@Override
		public FuelFilter create() {
			// TODO Auto-generated method stub
			return new FuelFilter();
		}
	}
}

class Belt extends Part{}

class FanBelt extends Belt{
	public static class Factory implements chapter14.Factory<FanBelt>{
		
		@Override
		public FanBelt create(){
			return new FanBelt();
		}
	}
}

public class RegisteredFactories {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++)
			System.out.println(Part.createRandom());
	}

}
