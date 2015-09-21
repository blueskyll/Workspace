package practice11;

import java.util.Scanner;

class StringMixer{
	public String process(String s) {
		int length = s.length();
		char[] c = new char[length];
		for (int i = 0; i < length / 2; i++) {
			char temp = s.charAt(i);
			c[i] = s.charAt(length - i - 1);
			c[length - i - 1] = temp;
		}
		return new String(c);
	}
}

class StringAdapter implements Processor{
	StringMixer stringMixer;
	
	public StringAdapter(StringMixer stringMixer){
		this.stringMixer = stringMixer;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "StringAdapter";
	}

	@Override
	public String process(Object s) {
		// TODO Auto-generated method stub
		return stringMixer.process((String)s);
	}
	
}

public class StringProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		Object result = Apply.process(new StringAdapter(new StringMixer()), s);
		System.out.println(result.toString());
	}

}
