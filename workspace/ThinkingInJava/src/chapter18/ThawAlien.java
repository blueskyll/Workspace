package chapter18;
import java.io.*;

public class ThawAlien {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("X.file")));
		Object alien = in.readObject();
		System.out.println(alien.getClass());
	}

}
