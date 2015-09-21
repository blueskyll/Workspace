package chapter13;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "/*! Here's a block of text to use as input to the regular expression matcher. Note " +
		           "that we'll first extract the block of text by looking for the special delimiters, then process" +
				   " the extracted block. !*/";
		System.out.println(s);
		
		Matcher m = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		
		if(m.find())
			s = m.group(1);
		
		s = s.replace(" {2,}", " ");
		
		s =s .replace("(?m)^ +", "");
		System.out.println(s);
		
		s =s.replaceFirst("[aeiou]", "(VOWEL1)");
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		
		Matcher m1 = p.matcher(s);
		while(m1.find()){
			m1.appendReplacement(sb, m1.group().toUpperCase());
		}
		
		m1.appendTail(sb);
		System.out.println(sb);
		
	}

}
