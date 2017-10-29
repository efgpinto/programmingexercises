package codility;


public class MinAvgTwoSlice {
    public int solution(int[] A) {
        
        double avgMin = (A[0]+A[1]) / 2.0;
        int minIndex = 0;
        
        for (int i = 2; i < A.length; i++) {
        	
        	double last = (A[i]+A[i-1]) / 2.0;
        	double last2 = (A[i]+A[i-1]+A[i-2]) / 3.0;
        	
        	if (last < avgMin) {
        		avgMin = last;
        		minIndex = i-1;
        	}
        		
        	if (last2 < avgMin) {
        		avgMin = last2;
        		minIndex = i-2;
        	}
        }
        
        return minIndex;
    }
    
    public static void main(String[] args) {
    	MinAvgTwoSlice e = new MinAvgTwoSlice();
    	System.out.println(e.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    	System.out.println(e.solution(new int[]{8, 8, 2, 2, 5, 1, 5, 1, 1}));
    	System.out.println(e.solution(new int[]{0, 3, 0, 1, 0, 2, 0}));
    	System.out.println(e.solution(new int[]{-1, -1, 0, 0, -1, -1, -1}));
		System.out.println(e.solution(new int[]{-1, -100, -100}));
		System.out.println(e.solution(new int[]{-1, -2, -3, -4, -5, -6, 11, -42, -1000, 200, 0, -10, -10, -10, -10, -10}));
    }
}
