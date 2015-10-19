package chapter18;

import java.io.*;

public class FreezeAlien {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"));
		Alien alien = new Alien();
		out.writeObject(alien);
	}

}
