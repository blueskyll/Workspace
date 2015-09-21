package demo.sort;

import java.util.Arrays;
import java.util.Random;

public class California implements Comparable<California>{

	/** 2.5.16 238
	 * @param args
	 */
	
	String str;
	public California(String sb) {
		// TODO Auto-generated constructor stub
		str = sb.toString();
	}

	@Override
	public int compareTo(California o) {
		// TODO Auto-generated method stub
		String str = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
		String s1 = this.str;
		String s2 = o.str;
		int length1 = s1.length();
		int length2 = s2.length();
		int i = 0;
		int j = 0;
		while(i  < length1 && j < length2){
			if(str.indexOf(s1.charAt(i)) < str.indexOf(s2.charAt(j))){
				return -1;
			}else if(str.indexOf(s1.charAt(i)) > str.indexOf(s2.charAt(j))){
				return 1;
			}
			i++;
			j++;
		}
		
		if(i != j){
			if(i == length1 - 1)
				return -1;
			else
				return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		California[] c = new California[5];
		Random rand = new Random();
		final int A = 'A', z = 'Z';
		
		for(int i = 0; i < c.length; i++){
			StringBuilder sb = new StringBuilder();
			while(sb.length() < 20){
				int number = rand.nextInt(z + 1);
				if(number >= A)
					sb.append((char)number);
			}//end while
			System.out.println(sb);
			c[i] = new California(sb.toString());
		}// end for
		
		
		Arrays.sort(c);
		System.out.println("------after sort------");
		for(int i = 0; i < c.length; i++)
			System.out.println(c[i].str);
	}

}
