package interviewbit;

import java.util.ArrayList;

public class NumRange {
	public int numRange(ArrayList<Integer> a, int b, int c) {
		
		if (b > c || a.isEmpty())
			return 0;
		
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			
			int sum = 0;
			for (int j = i; j < a.size(); j++) {

				sum += a.get(j);
				//System.out.println("s:" + sum + " - " + i + " - " + j);
				if (inRange(sum, b, c))
					count++;
				else if (sum > b)
					break;

			}
				
		}
		
		return count;
	}
	
	public boolean inRange(int num, int a, int b) {
		return num >= a && num <= b;
	}
	
	public static void main(String[] args) {
		NumRange k = new NumRange();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10); a.add(5); a.add(1); a.add(0); a.add(2);
		
		System.out.println(k.numRange(a, 6, 8));
	}
}
