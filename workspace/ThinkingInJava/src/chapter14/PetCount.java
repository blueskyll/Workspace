package chapter14;

import java.util.HashMap;

import chapter14.pets.*;

public class PetCount {

	static class PetCounter extends HashMap<String, Integer>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void count(String type){
			Integer quantity = get(type);
			if(quantity == null)
				put(type, 1);
			else
				put(type, quantity + 1);
		}
	}
	
	public static void countPets(PetCreator petCreator){
		PetCounter petCounter = new PetCounter();
		for(Pet pet : petCreator.arrayList(20)){
			System.out.println(pet.getClass().getSimpleName());
			if(pet instanceof Pet)
				petCounter.count("Pet");
			if(pet instanceof Mutt)
				petCounter.count("Mutt");
			if(pet instanceof Pug)
				petCounter.count("Pug");
			if(pet instanceof Dog)
				petCounter.count("Dog");
		}
		System.out.println(petCounter);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPets(new ForNameCreator());
	}

}
