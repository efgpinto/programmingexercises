package interviewbit;

import java.util.ArrayList;

public class PrettyPrint {
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {

		int size = a*2-1;
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(size);
		
		int range = 0;
		for (int i = 0; i < size; i++) {
			
			ArrayList<Integer> line = new ArrayList<Integer>(size);
			int range2 = 0;
			for (int j = 0; j < size; j++) {
				line.add(a-range2);

				if (j < (a-1) && range2 < range)
					range2++;
				else if (j >= (size-1-range2) && range2 > 0)
					range2--;
			}
			arr.add(line);
			range = i < (a-1) ? range+1 : range-1;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> l = prettyPrint(2);
		for (ArrayList<Integer> l1 : l) {
			for (Integer i : l1) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
