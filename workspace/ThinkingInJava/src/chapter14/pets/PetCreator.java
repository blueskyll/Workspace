package chapter14.pets;

import java.util.*;

public abstract class PetCreator {
	private Random rand = new Random(47);
	
	public abstract List<Class<? extends Pet>> types();
	
	public Pet randomPet(){
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public Pet[] createArray(int size){
		Pet[] result = new Pet[size];
		
		for(int i = 0; i < size; i++)
			result[i] = randomPet();
		return result;
	}
	
	public ArrayList<Pet> arrayList(int size){
		ArrayList<Pet> arrayList = new ArrayList<Pet>();
		Collections.addAll(arrayList, createArray(size));
		return arrayList;
	}
}
