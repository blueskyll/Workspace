package demo.sort;

public class KendallTau {

    // return Kendall tau distance between two permutations
	/*
	 * 2.5.19
	 * P238
	 */
    public static long distance(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array dimensions disagree");
        }
        int N = a.length;

        int[] ainv = new int[N];
        for (int i = 0; i < N; i++) ainv[a[i]] = i;//ainv将a的值作为索引，存放a数组中元素的索引

        Integer[] bnew = new Integer[N];
        for (int i = 0; i < N; i++) bnew[i] = ainv[b[i]];

        return Inversions.countInversions(bnew);
    }
    
    
    /*
     * maybe I will use the following code to realize bnew if I haven't seen this code. the time efficiency is n*n
     * for(int i = 0; i < n; i++)
     *   for(int j = 0; j < n; j++)
     *   {
     *        if(b[i] == a[j]) bnew[i] = j;
     *   }
     */


    // return a random permutation of size N
    public static int[] permutation(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            int r = (int) (Math.random() * (i + 1));
            a[i] = a[r];
            a[r] = i;
        }
        return a;
    }




    public static void main(String[] args) {

        // two random permutation of size N
        int N = 5;
        int[] a = KendallTau.permutation(N);
        int[] b = KendallTau.permutation(N);


        // print initial permutation
        for (int i = 0; i < N; i++)
            StdOut.println(a[i] + " " + b[i]);
        StdOut.println();

        StdOut.println("inversions = " + KendallTau.distance(a, b));
    }
    
    private static class Inversions {

    	public static int countInversions(Integer[] bnew)
    	{
    		int n=bnew.length;
    		int num=0;
    		for(int i=0;i<n-1;i++)
    		{
    			for(int j=i+1;j<n;j++)
    			{
    				if(bnew[i]>bnew[j])  //compare the later with the former, 
    					                //if the former > the later, it is one of the inversions.
    					                 //(because in b the later is behind of the former,
    					                 //but if the former value of bnew > the later value, 
    					                 //it is to say the former of b is the later one in a 
    					num++;
    			}
    				
    		}
    		return num;
    	}
    }

}