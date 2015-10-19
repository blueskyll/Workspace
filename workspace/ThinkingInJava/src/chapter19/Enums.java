package chapter19;

import java.util.Random;

public class Enums {
	private static Random rand = new Random(47);
	public static <T extends Enum<T>> T random(Class<T> className){
		return random(className.getEnumConstants());
	}
	
	public static <T> T random(T[] values){
		return values[rand.nextInt(values.length)];
	}
}
