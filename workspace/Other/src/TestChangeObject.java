import java.util.*;

public class TestChangeObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		System.out.println(d1);
		change(d1);
		System.out.println(d1.toString());
		
		change1(d1);
		System.out.println(d1.toString());
	}
	
	public static void change(Date b){
		b = new Date();
		b.setTime(b.getTime() * 2);
	}
	
	public static void change1(Date b){
		b.setTime(b.getTime() * 3);
	}

}
