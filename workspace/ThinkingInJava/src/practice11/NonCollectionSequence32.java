package practice11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.*;

class PetSequence{
	protected String[] str = {"123", "223", "dd"};
}

public class NonCollectionSequence32 extends PetSequence implements Iterable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Iterable<String> randomized(){
		return new Iterable<String>(){
			public Iterator<String> iterator(){
				List<String> shuffle = new ArrayList<String>(Arrays.asList(str));
				Collections.shuffle(shuffle, new Random(47));
				return shuffle.iterator();
			}
		};
	}
	
	public Iterable<String> reversed(){
		return new Iterable<String>(){
			public Iterator<String> iterator(){
				return new Iterator<String>(){

					int current = str.length - 1;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return current > -1;
					}

					@Override
					public String next() {
						// TODO Auto-generated method stub
						return str[current--];
					}

					@Override
					public void remove() {
						// TODO Auto-generated method stub
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new Iterator<String>(){
			private int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < str.length;
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				return str[index++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
		};
	}

}
