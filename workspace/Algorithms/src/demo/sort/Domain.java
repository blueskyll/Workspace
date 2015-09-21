package demo.sort;

import java.util.Arrays;

public class Domain implements Comparable<Domain>{

	/**2.5.14 P238
	 * @param args
	 */
	String[] field;
	public Domain(){
		field = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] names = {"ncepu.edu.cn", "baidu.com", "buaa.edu.cn", "sina.cn"};
		String[] names = {"ncepu.edu.cn", "baidu.com", "buaa.edu.cn", "sina.cn"};
		Domain[] domains = new Domain[names.length];
		for(int i = 0; i < names.length; i++)
		{
			String[] str = names[i].split("\\.");
			domains[i] = new Domain();
			domains[i].field = new String[str.length];
			domains[i].field = str;
		}
		Arrays.sort(domains, 0, domains.length);
		toString(domains);
	}

	public static void toString(Domain[] d){
		int length = d.length;
		for(int i = 0; i < length; i++){
			for(int j = d[i].field.length - 1; j >= 0; j--)
			{
				if(j == 0)
					System.out.println(d[i].field[j]);
				else
			    	System.out.print(d[i].field[j] + ".");
			}
		}
	}
	@Override
	public int compareTo(Domain d) {
		// TODO Auto-generated method stub
		int thisLength = this.field.length - 1;
		int dLength = d.field.length - 1;
		while(thisLength >= 0 && dLength >= 0){
			int compareValue = this.field[thisLength].compareTo(d.field[dLength]);
			if(compareValue < 0)
				return -1;
			else if(compareValue > 0)
				return 1;
			else{
				thisLength--;
				dLength--;
			}
		}
		if(thisLength != 0)
			return 1;
		else if(dLength != 0)
			return -1;
		return 0;
	}

}
