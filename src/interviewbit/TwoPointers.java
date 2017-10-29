package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers {
	public int diffPossible(ArrayList<Integer> a, int b) {
		if (a.size() < 2)
			return 0;
		
		for (int i = 0; i < a.size(); i++) {
			for (int j = i+1; j < a.size(); j++) {

				System.out.println("j" + j + " i:" + i);
				int dif = a.get(j) - a.get(i);
				
				if (dif == b)
					return 1;
				
				if (dif > b)
					break;
				
			}
		}
		
		return 0;
	}
	
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    
		ArrayList<Integer> temp = new ArrayList<Integer>(a);
		a.clear();
		
		if (b.isEmpty())
			return;
		
		int i = 0, j = 0;
		while (i < temp.size() && j < b.size()) {
			
			if (temp.get(i) < b.get(j)) {
				a.add(temp.get(i));
				i++;
			}
			else {
				a.add(b.get(j));
				j++;
			}
			
		}
		
		for (;i < temp.size(); i++)
			a.add(temp.get(i));
	    
		for (;j < b.size(); j++)
			a.add(b.get(j));
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		TwoPointers tp = new TwoPointers();
		
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1); l1.add(2); l1.add(3);
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(1); l2.add(2); l2.add(2); l2.add(3); l2.add(4);
		
		
		System.out.println(tp.diffPossible(l1, 0));
	}
}
