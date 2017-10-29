package interviewbit;

public class Strings {
	
	public int lengthOfLastWord(final String a) {
	    
	    int firstLetter = -1, tempLastSpace = 0, lastLetter = 0;
	    
	    for (int i = 0; i < a.length(); i++) {
	        if (a.charAt(i) == ' ') {
	            tempLastSpace = i+1;
	    	}
	        else {
	            firstLetter = tempLastSpace;
	            lastLetter = i;
	        }
	    }
	    
	    if (firstLetter == -1)
	    	return 0;
	    
	    return lastLetter-firstLetter+1;
	}
	
	public int strStr(final String haystack, final String needle) {
	    
	    if (needle.isEmpty() || haystack.isEmpty())
	        return -1;
	        
	    int index = 0;
	    for (int i = 0; i < haystack.length(); i++) {
	    	
	    	index = i;
	    	int j = 0;
	    	while(haystack.charAt(i) == needle.charAt(j)) {
	    			    		
	    		
	    		j++;
	    		i++;

		    	if (j == needle.length())
		    		return index;

		    	if (i == haystack.length())
		    		return -1;
	    	}
	    	
	    	if (haystack.charAt(i) != needle.charAt(j))
	    		i = index;
	    }
	    
	    return -1;
	}
	
	public int isPalindrome(String a) {
	    
	    a = a.toLowerCase();
	    
	    int i = 0, j = a.length()-1;
	    while (i < j && j >= 0 && i < a.length()) {
	        if (!Character.isLetterOrDigit(a.charAt(i))) {
	        	i++;
	        	continue;
	        }
	        
	        if (!Character.isLetterOrDigit(a.charAt(j))) {
	        	j--;
	        	continue;
	        }
	        
	        if (a.charAt(i) != a.charAt(j))
	        	return 0;
	        i++;
	        j--;
	    }
	    
	    return 1;	    
	}
	
	
	public int atoi(final String a) {
		
		int result = 0;
		
		int init = 0;
		while (init < a.length() && a.charAt(init) == ' ') //skip ' '
			init++;
		
		if (init >= a.length() || (!Character.isDigit(a.charAt(init)) && a.charAt(init) != '-' && a.charAt(init) != '+'))
			return 0;
		
		boolean neg = false;
		if (a.charAt(init) == '-') {
			neg = true;
			init++;
		}
		else if (a.charAt(init) == '+')
			init++;
		
		if (!Character.isDigit(a.charAt(init))) 
			return 0;
		
		int end = init+1;
		while (end < a.length() && Character.isDigit(a.charAt(end)))
			end++;
			
		while (init < end) {
			int soma = (int) ((a.charAt(init)-'0') * Math.pow(10, end-init-1));
			if (Integer.MAX_VALUE - soma < result)
				return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			
			result += soma;
			init++;			
		}
		
		
		return neg ? -1*result : result;
	}
	
	public static void main(String[] args) {
		Strings p = new Strings();
		/*System.out.println(p.strStr("ssass", "a"));
		System.out.println(p.strStr("ssassaaaa", "aaaa"));
		System.out.println(p.strStr("bbabaaab", "babaaa"));
		
		
		System.out.println(p.isPalindrome("ss aa ss"));
		System.out.println(p.isPalindrome("sa"));
		System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));*/
		

		System.out.println(p.atoi(" "));
		System.out.println(p.atoi(" sdsd "));
		System.out.println(p.atoi("82 21ass"));
		System.out.println(p.atoi("21ass"));
		System.out.println(p.atoi(""));
		System.out.println(p.atoi("-21ass"));
		System.out.println(p.atoi("   -214748364866"));
		System.out.println(p.atoi("- 588C340185Q  71"));
		System.out.println(p.atoi("-88297 248252140B12"));
		System.out.println(p.atoi(" + 2147483649"));
		 
	}
}
