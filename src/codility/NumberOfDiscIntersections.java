package codility;

import java.util.Arrays;

public class NumberOfDiscIntersections {
	
    public int solution(int[] A) {

    	long[] left = new long[A.length];
    	long[] right = new long[A.length];
    	
    	for (int i = 0; i < A.length; i++) {
    		left[i] = (long) i - (long) A[i]; 
    		right[i] = (long) i + (long) A[i]; 
    	}
    	
    	Arrays.sort(left);
    	Arrays.sort(right);
    	long active = 0, total = 0;
    	int l_i = 0, r_i = 0;
    	for (int i = 0; i < A.length; i++) {
    		while (l_i < A.length && left[l_i] <= right[r_i]) {
    			l_i++;
    			active++;
    			//System.out.println("avan�a esqeurda, activos: " + active);
    		}
    		
    		total += --active;
    		r_i++;

			//System.out.println("avan�a direita, activos: " + active + " - tot: " + total);
    		if (10000000 < total)
    			return -1;
    	}
    	
    	return (int) total;
    }
    
    public static void main(String[] args) {
    	NumberOfDiscIntersections e = new NumberOfDiscIntersections();
    	e.solution(new int[]{1,5,2,1,4,0});
    }
}
