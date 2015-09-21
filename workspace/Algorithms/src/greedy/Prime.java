package greedy;
import java.util.*;
public class Prime {

	private int V;
	private int[][] edge;
	private int[] closet; //node
	private int[] distTo;  //distance
	private boolean[] state;
	
	public void solve(){
		read();
		getMST();
	}
	
	public void getMST(){
		closet = new int[V + 1];
		distTo = new int[V + 1];
		state = new boolean[V + 1];
		for(int i = 2; i <= V; i++){
			closet[i] = 1;
			distTo[i] = edge[1][i];
			state[i] = false;
		}
		state[1] = true;
		for(int i = 2; i <= V; i++){// limit the number of the cycle
			int k = 0;
			int tempMin = Integer.MAX_VALUE;
			
			for(int j = 2; j <= V; j++){
				if(distTo[j] < tempMin && !state[j]){
					k = j;
					tempMin = distTo[j];
				}//end if
			}//end for j
			
			System.out.println("The " + (i - 1) + "th shortest path is " + closet[k] + " -> " + k + ", and the distance is " + distTo[k]);
			state[k] = true;
			
			for(int w = 2; w <= V; w++){
				if(distTo[w] > edge[w][k] && !state[w]){
					closet[w] = k;
					distTo[w] = edge[w][k];
				}
			}
		}//end for i
		
	}
	public void read(){
		Scanner scanner = new Scanner(System.in);
		V = scanner.nextInt();
		edge = new int[V + 1][V + 1];
		for(int i = 1; i <= V; i++){
			for(int j = 1; j < i && j != i; j++){
				edge[i][j] = scanner.nextInt();
				edge[j][i] = edge[i][j];
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prime().solve();
	}

}
