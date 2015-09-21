package demo.sort;

import java.util.Arrays;

public class Frequency {

	/**2.5.8 P238
	 * @param args
	 */
	
	private static class Record implements Comparable<Record>{
		private String content;
		private int frequency;
		
		public Record(String content, int frequency){
			this.content = content;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(Record o) {
			// TODO Auto-generated method stub
			if(frequency - o.frequency > 0)
				return -1;
			else if(frequency - o.frequency < 0)
				return 1;
			return 0;
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"a", "b","f","d", "c", "a", "b", "b", "b", "c"};
		Arrays.sort(strs);
		int N = strs.length;
		Record[] records = new Record[N];
		String word = strs[0];
		int frequency = 1;
		int M = 0;
		for(int i = 1; i < N; i++){
			if(!strs[i].equals(word)){
				records[M++] = new Record(word, frequency);
				word = strs[i];
				frequency = 0;
			}
			frequency++;
		}
		records[M++] = new Record(word, frequency);
		Arrays.sort(records, 0, M);
		for(int i = 0; i < records.length && records[i] != null; i++)
			System.out.println(records[i].frequency + " " + records[i].content);
	}

}
