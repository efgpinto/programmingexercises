package interviewbit;

import java.util.ArrayList;

public class Bulbs {
	
	public int bulbs(ArrayList<Integer> a) {
	
		int count = 0;
		int val = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == val) {
				count++;
				val = (val == 1) ? 0 : 1;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Bulbs b = new Bulbs();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0); arr.add(1); arr.add(0); arr.add(1);
		
		System.out.println(b.bulbs(arr));
	}

}
