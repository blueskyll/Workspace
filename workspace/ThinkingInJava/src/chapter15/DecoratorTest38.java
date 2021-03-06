package chapter15;

public class DecoratorTest38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chocolate c = new Chocolate(new Milk(new BasicCoffee()));
		System.out.println(c.getDescription());
	}
}

class BasicCoffee{
	String des;
	public BasicCoffee(){
		des = "Coffee with";
	}
	public String getDescription(){
		return des;
	}
}

abstract class Decorator extends BasicCoffee{
	public abstract String getDescription();
}

class Milk extends Decorator{
	BasicCoffee bc;
	
	public Milk(BasicCoffee bc){
		this.bc = bc;
	}
	public String getDescription(){
		return bc.getDescription() + " milk";
	}
}

class Chocolate extends Decorator{
	BasicCoffee bc;
	public Chocolate(BasicCoffee bc){
		this.bc = bc;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return bc.getDescription() + " Coffee";
	}
	
	
	
}