/**
 * 
 */
package demo.search;

/**
 * @author Home
 *
 */
public class GPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<String, Double> grades = new BinarySearchST<String, Double>(10);
		grades.put("A",  4.00);
		grades.put("B",  3.00);
	    grades.put("C",  2.00);
	    grades.put("D",  1.00);
	    grades.put("F",  0.00);
	    grades.put("A+", 4.33);
	    grades.put("B+", 3.33);
	    grades.put("C+", 2.33);
	    grades.put("A-", 3.67);
	    grades.put("B-", 2.67);
	    
	    int n = 0; 
	    double total = 0.0;
	    //int number = Integer.parseInt(10 * Math.round(Math.random()) + "");
	    int number = 1;
	    for(n = 0; n < number; n++){
	    	double k = Math.round(10 * Math.random());
	    	System.out.println(k);
	    	int temp = (int) k;
	    	String grade = null;
	    	switch(temp){
	    	case 0:
	    		grade = "A+";
	    		break;
	    	case 1:
	    		grade = "A";
	    		break;
	    	case 2:
	    		grade = "A-";
	    		break;
	    	case 3:
	    		grade = "B+";
	    		break;
	    	case 4:
	    		grade = "B";
	    		break;
	    	case 5:
	    		grade = "B-";
	    		break;
	    	case 6:
	    		grade = "C+";
	    		break;
	    	case 7:
	    		grade = "C";
	    		break;
	    	case 8:
	    		grade = "D";
	    		break;
	    	case 9:
	    		grade = "F";
	    		break;
	    	}// end switch
	    	
	    	double value = grades.get(grade);
	    	total += value;
	    }//end for
	    double gpa = total/n;
	    System.out.println("GPA= " + gpa);
	}
}


