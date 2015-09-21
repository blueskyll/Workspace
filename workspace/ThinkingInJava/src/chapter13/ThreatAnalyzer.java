package chapter13;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {

	static String threatData = "58.1.1.21@02/12/2005\n";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(threatData);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
		while(scanner.hasNext(pattern)){
			scanner.next(pattern);
			MatchResult m = scanner.match();
			String ip = m.group(1);
			System.out.println(ip);
		}

	}

}
