package chapter14.pets;

public class Pet {
	private String name;
	private static long counter;
	private final long id = counter++;
	
	public Pet(){
	}
	
	public Pet(String name){
		this.name = name;
	}
}
