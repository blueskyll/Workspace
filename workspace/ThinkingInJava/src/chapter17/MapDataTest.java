package chapter17;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;

import chapter15.Generator;

public class MapDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MapData.map(new Letters(), 11));
	}

}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer>{

	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number < size;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
		};
	}

	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		AbstractList<Integer> a;
		return new Pair<Integer, String>(number++, letter++ + "");
	}
	
}