package chapter17;
import java.util.*;

public class CountingIntegerList extends AbstractList<Integer>{

	private int size;
	
	public CountingIntegerList(int size){
		this.size = size < 0 ? 0 : size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountingIntegerList(10));
	}

	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
