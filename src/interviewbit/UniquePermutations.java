package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UniquePermutations {

	Comparator<ArrayList<Integer>> cmp = new Comparator<ArrayList<Integer>>() {

		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			
			for (int i = 0; i < o1.size() && i < o2.size(); i++) {
				if (o1.get(i) != o2.get(i))
					return o1.get(i) > o2.get(i) ? 1 : -1;
			}
			
			return 0;
		}
	}; 
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> l1) {
		//Collections.sort(l1);
		
		ArrayList<ArrayList<Integer>> l = permuteAux(l1, 0);
		Collections.sort(l, cmp);
		System.out.println(l);
		
		ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>();
		
		l2.add(l.get(0));
		for (int i = 0; i < l.size()-1; i++) {
			//System.out.println("Compare: " + l.get(i) + " = " + l.get(i+1));
			if (cmp.compare(l.get(i), l.get(i+1)) != 0)
				l2.add(l.get(i+1));
		}
		
		return l2;
	}
	
	private ArrayList<ArrayList<Integer>> permuteAux(ArrayList<Integer> remaining, int pos) {
	
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		if (remaining.isEmpty())
			return list;
		
		if (remaining.size() == 1) {
			list.add(remaining);
			return list;
		}
		
		if (remaining.size() == 2) {
			ArrayList<Integer> l1 = new ArrayList<Integer>();
			
			list.add(remaining);
			l1.add(remaining.get(1));
			l1.add(remaining.get(0));
			list.add(l1);
			
			return list;
		}
		
		for (int i = 0; i < remaining.size(); i++) {
			ArrayList<Integer> l2 = (ArrayList<Integer>) remaining.clone();
			l2.remove(i);
			
			for (ArrayList<Integer> l3 : permuteAux(l2, pos+1)) {
				ArrayList<Integer> l4 = new ArrayList<Integer>();
				l4.add(remaining.get(i));
				l4.addAll(l3);
				list.add(l4);
			}
		}
		
		return list;
	}

	
	public static void main(String[] args) {
		UniquePermutations p = new UniquePermutations();

		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(0);
		l1.add(0);
		l1.add(1);
		ArrayList<ArrayList<Integer>> l2 = p.permute(l1);
		System.out.println(l2);
	}


}
