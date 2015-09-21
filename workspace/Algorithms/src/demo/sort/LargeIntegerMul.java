package demo.sort;

public class LargeIntegerMul {

	/**
	 * @param args
	 */

	// int length;
	//
	// public LargeIntegerMul(){
	// length = 0;
	// }
	public String addStr(String s1, String s2) {
		String resultStr = new String();
		int s[] = new int[2400];
		int i, j, len_s1, len_s2, max;
		len_s1 = s1.length();
		len_s2 = s2.length();

		if (len_s1 >= len_s2) {
			max = len_s1;
			for (i = 0; i < len_s1 - len_s2; i++)
				s[i] = s1.charAt(i) - 48;
			for (i = len_s1 - len_s2, j = 0; i < len_s1 && j < len_s2; i++, j++)
				s[i] = s1.charAt(i) + s2.charAt(j) - 48 * 2;
		} else {
			max = len_s2;
			for (i = 0; i < len_s2 - len_s1; i++)
				s[i] = s2.charAt(i) - 48;
			for (i = len_s2 - len_s1, j = 0; i < len_s2 && j < len_s1; i++, j++)
				s[i] = s1.charAt(j) + s2.charAt(i) - 48 * 2;
		}

		for (i = max - 1; i > 0; i--) {
			if (s[i] >= 10) {
				s[i - 1] += s[i] / 10;
				s[i] = s[i] % 10;
			}
		}
		if (s[0] >= 10) {
			for (i = max; i >= 2; i--) {
				s[i] = s[i - 1];
			}
			s[1] = s[0] % 10;
			s[0] = s[0] / 10;
			max = max + 1;
		}

		for (i = 0; i < max; i++) {
			resultStr = String.format("%s%s", resultStr, s[i]);
		}
		return resultStr;
	}

	public String powerStr(String s, int n) {
		if (s.length() == 1 && s.charAt(0) == '0')
			return "0";
		else {
			for (int i = 0; i < n; i++)
				s = String.format("%s%s", s, "0");
		}
		return s;
	}

	public String mulStr(String s1, String s2, int i, int j, int m, int n) {
	    if(j - i > 1 && m - n == 0){
	    	String result1 = powerStr(mulStr(s1, s2, i, i + (j - i - 1) / 2, m, m + (n - m - 1)/ 2), 
					j - i + 1  - (j - i - 1)/2 - 1); //ac
			String result3 = mulStr(s1, s2, i + (j - i + 1) / 2, j, m, m + (n - m - 1) / 2);//bc
			return addStr(result1, result3);
	    }else if(n - m > 1 && j - i == 0){
	    	String result1 = powerStr(mulStr(s1, s2, i, i + (j - i - 1) / 2, m, m + (n - m - 1)/ 2), 
					 n - m + 1  - (n - m - 1)/2 - 1); //ac
			String result2 = mulStr(s1, s2, i, i + (j - i - 1) / 2, m + (n - m + 1) / 2, n);//ad
			return addStr(result1, result2);
			
	    }else if (j - i == 1 && (n - m) == 1) {
			return ((s1.charAt(i) - 48) * 10 + (s1.charAt(j) - 48))
					* ((s2.charAt(m) - 48) * 10 + (s2.charAt(n) - 48)) + "";
		}else if(j - i == 0 && n - m == 1){
			return (s1.charAt(i) - 48) * ((s2.charAt(m) - 48) * 10 + (s2.charAt(n) - 48)) + "";
		}else if(j - i == 1 && n - m == 0){
			return ((s1.charAt(i) - 48) * 10 + (s1.charAt(j) - 48)) * (s2.charAt(m) - 48) + "";
		}else if(j - i == 0 && n - m == 0){
			return (s1.charAt(i) - 48) * (s2.charAt(n) - 48) + "";
		}else {
			String result1 = powerStr(mulStr(s1, s2, i, i + (j - i - 1) / 2, m, m + (n - m - 1)/ 2), 
					j - i + 1 - (j - i - 1)/2 + n - m + 1  - (n - m - 1)/2 - 2); //ac
			String result2 = powerStr(mulStr(s1, s2, i, i + (j - i - 1) / 2, m + (n - m + 1) / 2, n),
					         j - i + 1  - (j - i - 1)/2 - 1);//ad
			String result3 = powerStr(mulStr(s1, s2, i + (j - i + 1) / 2, j, m, m + (n - m - 1) / 2), n - m + 1  -(n - m - 1)/2 - 1);//bc
			String result4 = mulStr(s1, s2, i + (j - i + 1) / 2, j, m + (n - m + 1) / 2, n);//bd
			return addStr(addStr(addStr(result1, result2), result3), result4);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "1234567812345678";
		String s2 = "11";
		LargeIntegerMul m = new LargeIntegerMul();
		String result = m.mulStr(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
		System.out.println(result);
	}

}
