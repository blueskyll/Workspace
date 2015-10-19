package chapter17;
import java.util.*;
public class SList<Item> {

	private Element first;
	
	private class Element{
		private Item item;
		private Element next;
		Element(Item item){
			this.item = item;
		}
	}
	
	public SList(){
		first = null;
	}
	
	public SListIterator<Item> iterator(){
		return new SListIterator<Item>();
	}
	
	private class SListIterator<Item>{

		Element cursor = first;
		
		public void add(Element element){
			element.next = first.next;
			first = element;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
