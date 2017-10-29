package codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneWall {
    public int solution(int[] H) {
    	
    	int totalBlocks = H.length;
    	Deque<Integer> stack = new ArrayDeque<Integer>();
    	
    	stack.push(H[0]);
    	for (int i = 1; i < H.length; i++) {
    		if (stack.isEmpty())
    			stack.push(H[i]);
    		else if (stack.peek() < H[i]) {
    			System.out.println("push " + H[i]);
    			stack.push(H[i]);
    		}
    		else if (H[i] == stack.peek()) {
    			totalBlocks--;
    			System.out.println("total " + totalBlocks);
    		}
    		else if (H[i] < stack.peek()) {
    			stack.pop();
    			i--;
    		}
    	}
        
        return totalBlocks;
    }
    
    public static void main(String[] args) {
    	StoneWall e = new StoneWall();
    	System.out.println(e.solution(new int[]{1,2,3,4}));
    	System.out.println(e.solution(new int[]{8,8,5,7,9,8,7,4,8}));
    	System.out.println(e.solution(new int[]{8,5,5,7,5}));
    	System.out.println(e.solution(new int[]{2, 5, 1, 4, 6, 7, 9, 10, 1}));
    }
}
