package chapter14.pets;

import java.util.*;

public class LiteralPetCreator extends PetCreator{

	public final static List<Class<? extends Pet>> allTypes = 
			Collections.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Mutt.class, Pug.class));
	private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(types);
	}

	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}

}
