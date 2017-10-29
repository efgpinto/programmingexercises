package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
		
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		
		Collections.sort(a);
		
		for (int i = 0; i < a.size(); i++) {
			l.addAll(listSubsets(a, i, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
			
		}
		
		
		return l;
	}
	
	private ArrayList<ArrayList<Integer>> listSubsets(ArrayList<Integer> a, int i, ArrayList<Integer> acum, ArrayList<ArrayList<Integer>> acumT) {
		
		if (i >= a.size())
			return acumT;

		ArrayList<Integer> ln = new ArrayList<Integer>(acum);
		ArrayList<ArrayList<Integer>> newAcum = new ArrayList<ArrayList<Integer>>(acumT);
		newAcum.add(ln);
		ln.add(a.get(i));
		
		return listSubsets(a, i+1, ln, newAcum);
	}

	public static void main(String[] args) {
		
		Subsets s = new Subsets();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(2); a.add(3);
		System.out.println(s.subsetsWithDup(a));
	}

}
