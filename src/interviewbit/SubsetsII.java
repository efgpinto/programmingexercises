package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
		
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		
		Collections.sort(a);
		
		for (int i = 0; i < a.size(); i++) {
			System.out.println("\nFIM:" +listSubsets(a, i, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
			
		}
		
		
		return l;
	}
	
	private ArrayList<ArrayList<Integer>> listSubsets(ArrayList<Integer> a, int i, ArrayList<Integer> acum, ArrayList<ArrayList<Integer>> acumT) {
		
		if (i >= a.size())
			return new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(a.get(i));
		System.out.println("ACUM:" + acum);
		
		acumT.add(l);
		System.out.println("ACUMT:" + acumT);
		
		acumT.addAll(listSubsets(a, i+1, acum, acumT));
		
		return acumT;
	}

	public static void main(String[] args) {
		
		SubsetsII s = new SubsetsII();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(2); a.add(2);
		System.out.println(s.subsetsWithDup(a));
	}

}
