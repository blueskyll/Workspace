package chapter14;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot{

	private String name;
	public SnowRemovalRobot(String name){
		this.name = name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String model() {
		// TODO Auto-generated method stub
		return "SnowBot series 11";
	}

	@Override
	public List<Operation> operations() {
		// TODO Auto-generated method stub
		return Arrays.asList(
				new Operation(){
					public String description(){
						return name + " can shoveling snow";
					}
					
					public void commands(){
						System.out.println(name + " shoveling snow");
					}
				},
				new Operation(){
					public String description(){
						return name + " can chip ice";
					}
					public void commands(){
						System.out.println(name + " chipping ice");
					}
				});
	}

}
