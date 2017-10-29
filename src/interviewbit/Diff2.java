package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Diff2 {

	public int diffPossible(final List<Integer> a, int b) {
	    
		if (b < 0)
			return 0;
		
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    
	    for (int i = 0; i < a.size(); i++) {
	    	map.put(a.get(i), i);
	    }
	    
	    for (int i = 0; i < a.size(); i++) {
	    	if (map.containsKey(a.get(i)+b) && map.get(a.get(i)+b) != i)
	    		return 1;
	    }
	    
	    return 0;
	}
	
	public static void main(String[] args) {
		Diff2 tp = new Diff2();
		
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1); l1.add(5); l1.add(3);
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(8); l2.add(2); l2.add(12); l2.add(-3); l2.add(4);
		
		
		System.out.println(tp.diffPossible(l2, 9));
	}

}
