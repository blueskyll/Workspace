package chapter17;

import java.util.LinkedHashMap;

import chapter15.Generator;




public class MapData<K, V> extends LinkedHashMap<K, V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MapData(Generator<Pair<K, V>> gen, int quantity){
		for(int i = 0; i < quantity; i++){
			Pair<K, V> pair = gen.next();
			put(pair.key, pair.value);
		}
	}
	
	public MapData(Generator<K> kGen, Generator<V> vGen, int quantity){
		for(int i = 0; i < quantity; i++)
		{
			put(kGen.next(), vGen.next());
		}
	}
	
	public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity){
		return new MapData<K, V>(gen, quantity);
	}
}
