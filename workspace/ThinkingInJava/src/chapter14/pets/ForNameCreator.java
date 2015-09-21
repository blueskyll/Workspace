package chapter14.pets;

import java.util.*;

public class ForNameCreator extends PetCreator{

	private static List<Class<? extends Pet>> types =
			new ArrayList<Class<? extends Pet>>();
	private static String[] names = {
			"chapter14.pets.Dog",
			"chapter14.pets.Mutt",
			"chapter14.pets.Pug"
			};
	
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}
	
	@SuppressWarnings("unchecked")
	private static void loader(){
		for(String name : names)
			try {
				types.add((Class<? extends Pet>)Class.forName(name));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
	}
	
	static{
		loader();
	}

}
