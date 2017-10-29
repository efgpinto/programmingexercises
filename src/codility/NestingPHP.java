package codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class NestingPHP {
	
    public int solution(String S) {
        
    	Deque<Integer> stack = new ArrayDeque<Integer>();
        char[] str = S.toCharArray();
        
        for (int i = 0; i < str.length; i++) {
        	if (str[i] == '(')
        		stack.push(1);
        	else if (str[i] == ')') {
        	    if (stack.isEmpty())
        	        return 0; 
        		stack.pop();
        	}
        }
        
        if (stack.isEmpty())
        	return 1;
        return 0;
    }
    
}
