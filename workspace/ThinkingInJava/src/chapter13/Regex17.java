package chapter13;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex17 {

	public static void readFileLine(){
		String filePath ="F:\\workspace\\ThinkingInJava\\src\\chapter13\\Groups12.java";
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String lineStr = null;
			int line = 1;
//			Matcher m = Pattern.compile("\\/\\/.*|\\/\\*.*.\\*\\/").matcher("");
			Matcher m = Pattern.compile("(//.*)|(/\\*.*)|(.\\*\\/)").matcher("");
			while((lineStr = reader.readLine()) != null){
				 m.reset(lineStr);
				 while(m.find())
					 System.out.println(m.group());
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}finally{
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFileLine();
	}

}
