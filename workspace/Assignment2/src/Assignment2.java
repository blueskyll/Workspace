import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * SY1406406 刘岚
 */
public class Assignment2 {

	/**
	 * @param args
	 */
	int n; // the number of city;
	int[][] cityDistance; // the distance of every two cities;
	int[][] cityCost;// the cost of every two cities;
	int bestc; // the current minimal cost
	private class QueueNode{
		int n; // the number of the city
		int length; // the distance to the city
		int cost; // the cost to the city
		int cityCount; //the count of the city on the path
		int[] cityOrder; //the city order on the path
		QueueNode(int nn, int ll, int cc, int cityCount) {
			n = nn;
			length = ll;
			cost = cc;
			this.cityCount = cityCount;
			cityOrder = new int[50];
			for(int i = 0; i <= 49; i++)
				cityOrder[i] = 0;
		}
		
		private void setCityOrder(int[] array){
			for(int i = 0; i <= 49; i++)
				cityOrder[i] = array[i];
		}
	}

	public void init(Assignment2 a, String fileName1, String fileName2) {
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		a.cityDistance = new int[50][50];
		a.cityCost = new int[50][50];
		a.n = 50;
		a.bestc = 0;
		try {
			reader1 = new BufferedReader(new FileReader(file1));
			
			
			String tempString1 = null;
			int line1 = 0;// 一次读入一行，直到读入null为文件结束

			while ((tempString1 = reader1.readLine()) != null) {
				String s[] = tempString1.split("\t");
				for(int i = 0; i < s.length; i++)
					a.cityDistance[line1][i] = Integer.parseInt(s[i]);
				line1++;
			}
			reader1.close();
			
			int line2 = 0;
			reader2 = new BufferedReader(new FileReader(file2));
			String tempString2 = null;
	
			while ((tempString2 = reader2.readLine()) != null) {
				String s[] = tempString2.split("\t");
				for(int i = 0; i < s.length; i++)
					a.cityCost[line2][i] = Integer.parseInt(s[i]);
				line2++;
			}
			reader2.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader1 != null) {
				try {
					reader1.close();
				} catch (IOException e1) {
				}
			}
			if (reader2 != null) {
				try {
					reader2.close();
				} catch (IOException e1) {
				}
			}
			
		}
	}
	
	public void shortest(Assignment2 a){
		Queue<QueueNode> queue = new Queue<QueueNode>();
		QueueNode enode = new QueueNode(0, 0, 0, 1);
		enode.cityOrder[0] = 0;
		int maxDistance = 9999;
		int maxCost = 1500;
		int[] dist = new int[50];
		int cost = 0;
		QueueNode result = new QueueNode(0,9999,0, 0);
		for(int i = 0; i <= 49; i++)
		{
			dist[i] = maxDistance;
		}
		while(true){
			for(int j = 0; j <= 49; j++){
				if(a.cityDistance[enode.n][j] < maxDistance && (enode.length + a.cityDistance[enode.n][j] < dist[j])
						&& (enode.cost + a.cityCost[enode.n][j] <= maxCost)){
					dist[j] = enode.length + a.cityDistance[enode.n][j];
					cost = enode.cost + a.cityCost[enode.n][j];
					QueueNode node = new QueueNode(j, dist[j], cost, enode.cityCount + 1);
					node.setCityOrder(enode.cityOrder);
					node.cityOrder[enode.cityCount] = j;
					queue.enqueue(node);
					
					if(j == 49)
					{
						result = node;
					}
				}// end if
			}// end for
			if(queue.isEmpty())
				break;
			else{
				enode = queue.dequeue();
			}
		}//end while
		System.out.println("the best path is:");
		for(int i = 0; i < result.cityCount; i++)
		{
			if(i == result.cityCount - 1)
				System.out.print(result.cityOrder[i] + 1);
			else
				System.out.print(result.cityOrder[i] + 1 + "->" );
		}
		System.out.println();
		System.out.println("the length is:" + dist[49]);
		System.out.println("the cost is:" + result.cost);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		Assignment2 a = new Assignment2();
		
		String dir = System.getProperty("user.dir");
		String fileName1 = dir + "\\m1.txt";
		String fileName2 = dir + "\\m2.txt";
		a.init(a, fileName1, fileName2);
		a.shortest(a);
		
	}

}
