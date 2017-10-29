package hackerrank;

import java.util.Stack;

public class BalancedStringBrackets {
	
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        
        char[] s = expression.toCharArray();
        for (char c : s) {
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        stack.clear();
        return stack.empty();
    }
  
    public static void main(String[] args) {
    	
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
        
    }

}
