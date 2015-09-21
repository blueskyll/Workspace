package practice11;

import java.util.*;

public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
		gerbils.put("Fuzzy", new Gerbil(0));
		gerbils.put("Spot", new Gerbil(1));
		gerbils.put("Crystal", new Gerbil(2));
		
		Iterator<String> iterator = gerbils.keySet().iterator();
		while(iterator.hasNext()){
			String s = iterator.next();
			System.out.print(s + " : ");
			gerbils.get(s).hop();
		}
	}

}
