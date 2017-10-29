package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {
	
	public int kthsmallest(final List<Integer> a, int k) {
	
		PriorityQueue<Integer> mins = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		
		int i = 0;
		for (; i < k; i++) {
			mins.add(a.get(i));
		}
		
		for (; i < a.size(); i++) {
			System.out.println("a: " + a.get(i) + " min " + mins.peek());
			if (a.get(i) < mins.peek()) {
				mins.poll();
				mins.add(a.get(i));
			}
		}
		
		return mins.peek();
	}
	
	public static void main(String[] args) {
		KthSmallestElement k = new KthSmallestElement();
		List<Integer> a = new ArrayList<Integer>();
		a.add(2); a.add(1); a.add(4); a.add(3); a.add(2);
		
		System.out.println(k.kthsmallest(a, 3));
	}
}
