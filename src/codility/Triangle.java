package codility;

import java.util.Arrays;

public class Triangle {
	public int solution(int[] A) {
        Arrays.sort(A);
        
        if (A.length < 3)
            return 0;
            
        for (int i = 1; i < A.length-1; i++) {
            if ( ((0.0+A[i-1]+A[i]) > A[i+1]) &&
                    ((0.0+A[i]+A[i+1]) > A[i-1]) && 
                    ((0.0+A[i-1]+A[i+1]) > A[i]) )
                return 1;
        }
        
        return 0;
    }
}
