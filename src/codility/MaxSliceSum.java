package codility;


public class MaxSliceSum {
    public int solution(int[] A) {
        if (A.length == 0)
        	return 0;
    	
        int maxSum = A[0], current = A[0];
        for (int i = 1; i < A.length; i++) {
            current = (A[i] + current) > A[i] ? A[i] + current : A[i];     
            maxSum = current > maxSum ? current : maxSum;
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
    	MaxSliceSum m = new MaxSliceSum();
    	System.out.println(m.solution(new int[]{-10}));
    	System.out.println(m.solution(new int[]{3,2,-6,4,0}));
    	System.out.println(m.solution(new int[]{-5,10,1,-5,11,3,-5}));
    }
}
