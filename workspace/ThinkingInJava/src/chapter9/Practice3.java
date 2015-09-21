package chapter9;

abstract class Display{
	public Display(){
		print();
	}
	public abstract void print();
}

class ExDisplay extends Display{
	private int i = 1;
	public void print(){
		System.out.println(i);
	}
}
public class Practice3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExDisplay().print();
	}

}
