package chapter17;
import java.util.*;

public class Countries {

	public static final String[][] DATA = {
			{"China", "Beijing"},
			{"ALGERIA", "Algiers"},
			{"America", "Waston"},
			{"France", "Paris"},
			{"Japan", "Tokyo"},
			{"England", "London"},
			{"Finland", "Helsinki"},
			{"Gernamy", "Berlin"},
			{"Hungary", "Budapest"},
			{"Poland", "Warsaw"}
	};
	
	private static class FlyweightMap extends AbstractMap<String, String>{
		private static class Entry implements Map.Entry<String, String>{

			int index;
			
			Entry(int index) { this.index = index; }
			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return DATA[index][1];
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int hasCode(){
				return DATA[index][0].hashCode();
			}
			
		}
		
		static class EntrySet extends AbstractSet<Map.Entry<String, String>>{
			private int size;
			EntrySet(int size){
				if(size < 0)
					this.size = 0;
				else if(size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}
			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return new Iter();
			}
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return size;
			}
			
			private class Iter implements Iterator<Map.Entry<String, String>>{

				private Entry entry = new Entry(-1);

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return entry.index < size - 1;
				}

				@Override
				public java.util.Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return entry;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					
				}
				
			
				
			}
		}
		
		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			// TODO Auto-generated method stub
			return entries;
		}
	}
	
	
	static Map<String, String> select(final int size){
		return new FlyweightMap(){
			public Set<Map.Entry<String, String>> entrySet(){
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String, String> map = new FlyweightMap();
	
	public static Map<String, String> capitals(){
		return map;
	}
	
	public static Map<String, String> capitals(int size){
		return select(size);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(capitals(1));
	}

}
