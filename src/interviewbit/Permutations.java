package interviewbit;

import java.util.ArrayList;

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		
		return permuteAux(a, 0);
	}
	
	public ArrayList<ArrayList<Integer>> permuteAux(ArrayList<Integer> remaining, int pos) {
		
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
		Permutations p = new Permutations();

		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		ArrayList<ArrayList<Integer>> l2 = p.permute(l1);
		System.out.println(l2);
	}

}
