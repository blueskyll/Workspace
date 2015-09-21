package chapter14;

import chapter14.pets.Pet;
import chapter14.pets.Pets;

public class PetCount4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet pet : Pets.cerateArray(20))
			counter.count(pet);
		System.out.println(counter);
	}

}
