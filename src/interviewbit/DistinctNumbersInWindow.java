package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		if (B > A.size())
			return l;
		
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < B; i++) {
			if (hash.containsKey(A.get(i)))
				hash.put(A.get(i), hash.get(A.get(i))+1);
			else
				hash.put(A.get(i), 1);	
		}
		l.add(hash.size());
		
		
		for (int i = B; i < A.size(); i++) {
			
			int rem = A.get(i-B);
			if (hash.get(rem) > 1)
				hash.put(rem, hash.get(rem)-1);
			else
				hash.remove(rem);
			
			int acum = hash.containsKey(A.get(i)) ? hash.get(A.get(i))+1 : 1;
			hash.put(A.get(i), acum);
			
			l.add(hash.size());
		}
		
		
		return l;
    }
	
	public static void main(String[] args) {
		DistinctNumbersInWindow d = new DistinctNumbersInWindow();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1); arr.add(2); arr.add(1); arr.add(3); arr.add(4); arr.add(3);
		
		System.out.println(d.dNums(arr, 3));
	}

}
