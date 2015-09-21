package chapter14;

import java.util.*;

import chapter14.pets.LiteralPetCreator;
import chapter14.pets.Pet;
import chapter14.pets.Pets;

public class PetCount3 {

	static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{
		public PetCounter(){
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}
		
		public void count(Pet pet){
			for(Map.Entry<Class<? extends Pet>, Integer>  pair : entrySet()){
				if(pair.getKey().isInstance(pet))
					put(pair.getKey(), pair.getValue() + 1);
			}
		}
		
		public String toString(){
			StringBuilder result = new StringBuilder("{");
			for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()){
				result.append(pair.getKey());
				result.append("=");
				result.append(pair.getValue());
				result.append(",");
			}
			result.delete(result.length() - 2, result.length());
			result.append("}");
			return result.toString();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetCounter petCounter = new PetCounter();
		for(Pet pet : Pets.cerateArray(20)){
			System.out.println(pet.getClass().getSimpleName() + " ");
			petCounter.count(pet);
		}
		System.out.println("-------------");
		System.out.println(petCounter);
	}

}
