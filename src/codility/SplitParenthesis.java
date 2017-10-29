package codility;


public class SplitParenthesis {
	
    public int solution(String S) {
        
        char[] str = S.toCharArray();
        
        int i = 0;
        for (int j=str.length-1; i < j; i++, j--) {
        	System.out.println("i"+ i + "j" + j);
        	while (i < str.length && i < j && str[i] != '(') {
        		i++;
        		System.out.println("incrementa i" + i + "j" + j);
        		if (i == str.length-1)
        			return 0;
    			if (i >= j)
        			return ++i;
        	}
        	while(j > 0 && i < j && str[j] != ')') {
        		System.out.println("decrementa j");
        		j--;

            	if (i >= j)
            		return i;
        	}
        }
        
        return i;
    }
    
    public static void main(String[] args) {
    	SplitParenthesis e = new SplitParenthesis();
    	System.out.println("R:"+e.solution("(())))(")+"\n");
    	System.out.println("R:"+e.solution("(())")+"\n");
    	System.out.println("R:"+e.solution("(((())")+"\n");
    	System.out.println("R:"+e.solution("")+"\n");
    	System.out.println("R:"+e.solution("((((((")+"\n");
    	System.out.println("R:"+e.solution("((((()")+"\n");
    	System.out.println("R:"+e.solution("())))")+"\n");
    	System.out.println("R:"+e.solution("((((((")+"\n");
    	System.out.println("R:"+e.solution(")))))")+"\n");
    }
}
