package chapter18;

import java.io.*;

public class Ex27 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Family f = new Family(new People("ll"), 1);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("family.out")));
		out.writeObject(f);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("family.out")));
		Family fa = (Family)in.readObject();
		System.out.println(fa.toString());
		System.out.println(fa.p);
	}

}

class Family implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	People p;
	private int id;
	public Family(People p, int id){
		this.id = id;
		this.p = p;
	}
	
	public String toString(){
		return id + ":" + p.toString();
	}
	
}

class People implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public People(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
