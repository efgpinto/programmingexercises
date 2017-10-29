package hackerrank;

import java.util.Hashtable;

public class RansomNote {
	
	public static void matchStrings(String[] s1, String[] s2) {
		Hashtable <String, Integer> table = new Hashtable<String, Integer>();
		
		for (String s : s1) {
			if (table.containsKey(s))
				table.replace(s, table.get(s)+1);
			else {
				table.put(s, 1);
			}
		}
		
		for (String s : s2) {
			if (table.containsKey(s)) {
				if (table.get(s) > 0)
					table.replace(s, table.get(s)-1);
				else
					table.remove(s);					
			}
			else {
				System.out.print("No");
				return;
			}
		}
		
		System.out.print("Yes");
	}
	
    public static void main(String[] args) {
        matchStrings(new String[]{"give","me","the","grand","night"},new String[]{"give","me","grand","night"});
        matchStrings(new String[]{"me"},new String[]{"give"});
    }
}
