package codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dominator {
    public int solution(int[] A) {
    	
        Deque<Integer> l = new ArrayDeque<Integer>();
        
        for (int i = 0; i < A.length; i++) {
            if (!l.isEmpty() && A[i] != A[l.peek()]) {
                l.pop();
            }
            else {
                l.push(i);
            }
        }
        
        if (l.isEmpty())
        	return -1;
        
        int index = l.pop();
        int candidate = A[index], occurrences = 0;
        for (int i : A)
        	if (i == candidate)
        		occurrences++;
        
        if (occurrences > (A.length/2))
        	return index;
        return -1;
    }
    
    public static void main(String[] args) {
    	Dominator d = new Dominator();
		System.out.println(d.solution(new int[]{3,4,3,2,3,-1,3,3}));
		System.out.println(d.solution(new int[]{0,0,1,1,1}));
		System.out.println(d.solution(new int[]{0,0,1,1}));
		System.out.println(d.solution(new int[]{2, 1, 1, 3, 4}));
		
    }
}
