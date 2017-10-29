package codility;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    public int solution(int[] A) {
    	
    	if (A.length < 3)
    		return 0;

    	List<Integer> peaksIdx = new ArrayList<Integer>();
    	List<Integer> peaksDistToPrev = new ArrayList<Integer>();
    	
    	int lastPeakIdx = 0;
    	for (int i = 1; i < A.length-1; i++) {
    		if (A[i-1] < A[i] && A[i] > A[i+1]) {
    			peaksIdx.add(i);
    			peaksDistToPrev.add(i-lastPeakIdx);
    			lastPeakIdx = i;
    		}
    	}
    		
    	//for (int i : peaksIdx)
    		//System.out.println(i);
    	int flags = 1;
    	int flagDist = peaksIdx.size(), lastFlag = 1;
    	for (int i = 1; i < peaksIdx.size() && flags < flagDist; i++) {
    		int dist = peaksIdx.get(i) - lastFlag;
    		if (dist < flagDist){ 
    			flagDist--;
    			i=1;
    			lastFlag=1;
    		}
    		else
    			lastFlag = peaksIdx.get(i);
    	}
    	
    	return flagDist;
    }
    
    public static void main(String[] args) {
    	Flags f = new Flags();
    	System.out.println("3="+f.solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
    	System.out.println("0="+f.solution(new int[]{1,2}));
    	System.out.println("1="+f.solution(new int[]{1,5,1}));
    	System.out.println("2="+f.solution(new int[]{1,5,1,5,1,5,1}));
    	System.out.println("2="+f.solution(new int[]{1,5,1,5,1,5,1,5}));
    	System.out.println("2="+f.solution(new int[]{1,5,1,5,1,5,1,5,1}));
    	System.out.println("0="+f.solution(new int[]{1,5,5,5,5,5,5,5,1}));
    }
}
