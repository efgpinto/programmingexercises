package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolats {

    public int nchoc(int time, ArrayList<Integer> B) {
    
    	PriorityQueue<Integer> chocs = new PriorityQueue<Integer>(B.size(), Collections.reverseOrder());
    	for (int i : B) {
    		chocs.add(i);
    	}

    	long acum = 0;
    	for (int i = 0; i < time; i++) {
    		Integer val = chocs.poll();
			acum += val;
			acum = acum % 1000000007;
    		
    		int new_value = (int) (val / 2);
    		chocs.add(new_value);
    	}
    		
    	return (int) acum;
    }
	
	public static void main(String[] args) {
		MagicianAndChocolats mc = new MagicianAndChocolats();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(2147483647);
		l.add(2000000014);
		l.add(2147483647);

		/*l.add(20);
		l.add(20);
		l.add(20);
		*/
		System.out.println("TOtal: " +mc.nchoc(4, l));
	}

}
